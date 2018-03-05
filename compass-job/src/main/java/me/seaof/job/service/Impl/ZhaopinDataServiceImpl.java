package me.seaof.job.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.seaof.job.common.JedisStateCode;
import me.seaof.job.jsoup.AnalyzeZhaopin;
import me.seaof.job.service.ZhaopinDataService;
import me.seaof.job.vo.Aqi;
import me.seaof.job.vo.AqiList;
import me.seaof.job.vo.City;
import me.seaof.job.vo.CityList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Watter on 2018-02-28
 */
@Service
public class ZhaopinDataServiceImpl implements ZhaopinDataService{

    private final static Logger logger = LoggerFactory.getLogger(ZhaopinDataServiceImpl.class);

    private static final String ZPIN_URL = "http://sou.zhaopin.com/jobs/searchresult.ashx?sm=0&fl=763&isadv=0&sb=2&isfilter=1&p=1&pd=1&jl=";

    private static final String CITY_AQI = "http://www.pm25.in/api/querys/only_aqi.json?token=5j1znBVAsnSf5xQyNQyq&city=";

    private static final long TIME_OUT = 1800L; // 1800s

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CityBaseDataServiceImpl cityBaseDataService;

    /**
     * 获取各个城市当天发布的职位信息数量
     * @return
     */
    @Override
    public List<City> getDataByCity() {

        List<City> cityList = new ArrayList<>();

        List<City> cities = cityBaseDataService.cityList();

        for (City city:cities) {
            try {
                City ci = this.toJedis(city);
                cityList.add(ci);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cityList;
    }

    private City toJedis(City c) throws Exception{
        String key = JedisStateCode.CITY_INFO + c.getCname();
        ObjectMapper mapper = new ObjectMapper();
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if(stringRedisTemplate.hasKey(key)){
            logger.info("Redis has data");
            c = mapper.readValue(ops.get(key),City.class);
        }else{
            String job_url = ZPIN_URL + c.getCname();
            c.setVal(AnalyzeZhaopin.zhaoPinNum(job_url, "UTF-8"));

            String aqi_url = CITY_AQI + c.getCname();
            ResponseEntity<String> respString = restTemplate.getForEntity(aqi_url, String.class);
            AqiList aqiList = null;
            if (respString.getStatusCodeValue() == 200) {
                String str = JSON.toJSONString(respString.getBody());
                aqiList = mapper.readValue(str, AqiList.class);
                List<Aqi> list = aqiList.getAqiList();
                c.setAqi(list.get(list.size()-1).getAqi());
            }
        }
        // 数据写入缓存
        ops.set(key, JSON.toJSONString(c), TIME_OUT, TimeUnit.SECONDS);

        return c;
    }

    @Override
    public void syncDateByCityName(City c){
        try {
            this.toJedis(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

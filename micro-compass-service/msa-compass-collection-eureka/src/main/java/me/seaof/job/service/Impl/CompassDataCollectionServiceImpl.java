package me.seaof.job.service.Impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.seaof.job.common.JedisStateCode;
import me.seaof.job.jsoup.AnalyzeZhaopin;
import me.seaof.job.service.ZuulClient;
import me.seaof.job.service.CompassDataCollectionService;
import me.seaof.job.vo.Aqi;
import me.seaof.job.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Creat By Watter @DATA
 */
@Service
public class CompassDataCollectionServiceImpl implements CompassDataCollectionService {

    private final static Logger logger = LoggerFactory.getLogger(CompassDataCollectionServiceImpl.class);

    private static final String ZPIN_URL = "http://sou.zhaopin.com/jobs/searchresult.ashx?sm=0&fl=763&isadv=0&sb=2&isfilter=1&p=1&pd=1&jl=";

    private static final String CITY_AQI = "http://www.pm25.in/api/querys/only_aqi.json?token=5j1znBVAsnSf5xQyNQyq&city=";

    private static final long TIME_OUT = 100000L; // 1800s

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    public ZuulClient zuulClient;

    /**
     * 同步城市相关信息
     * @param
     */
    @Override
    public void syncDateByCityName(){
        try {
            ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
            String key = JedisStateCode.ALL_JOB;
            List<City> list = null;
            list = zuulClient.listCity();
            for (City city:list) {
                logger.info("Sync Data for :" + city.getCname());
                this.toJedis(city);
            }
            // 数据写入缓存
            ops.set(key, JSON.toJSONString(list), TIME_OUT, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            if (respString.getStatusCodeValue() == 200) {
                String str = respString.getBody();
                List<Aqi> list = JSONArray.parseArray(str,Aqi.class);
                c.setAqi(list.get(list.size()-1).getAqi());
            }
        }
        // 数据写入缓存
        ops.set(key, JSON.toJSONString(c), TIME_OUT, TimeUnit.SECONDS);
        return c;
    }

}

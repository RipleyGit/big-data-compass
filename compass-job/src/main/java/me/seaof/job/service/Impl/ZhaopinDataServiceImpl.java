package me.seaof.job.service.Impl;

import com.alibaba.fastjson.JSON;
import me.seaof.job.common.GetCityList;
import me.seaof.job.common.JedisStateCode;
import me.seaof.job.jsoup.AnalyzeZhaopin;
import me.seaof.job.service.ZhaopinDataService;
import me.seaof.job.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Watter on 2018-02-28
 */
@Service
public class ZhaopinDataServiceImpl implements ZhaopinDataService{

    private final static Logger logger = LoggerFactory.getLogger(ZhaopinDataServiceImpl.class);

    private static final String ZPIN_URL = "http://sou.zhaopin.com/jobs/searchresult.ashx?jl=";

    private static final long TIME_OUT = 72000L; // 设置失效时间为20小时

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取各个城市当天发布的职位信息数量
     * @return
     */
    @Override
    public String getDataByCity() {
        String jodDec = null;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String data = df.format(new Date());

        try {
            jodDec = this.doGetJobInfo(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jodDec;
    }

    @Override
    public void syncDateByCityName(String key){
        this.doGetJobInfo(key);
    }


    private String doGetJobInfo(String key) {
        String strBody = null;
        // 先查缓存，缓存有的取缓存中的数据

        key = key + JedisStateCode.ALL_JOB; //使用日期加标识码作为Redis唯一标识符

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        if (stringRedisTemplate.hasKey(key)) {
            logger.info("Redis has data");
            strBody = ops.get(key);
        } else {
            logger.info("Redis don't has data");
            // 缓存没有，再调用服务接口来获取
            try {
                List<City> cityList = GetCityList.listCity();
                for (City city:cityList) {
                    String job_url = ZPIN_URL + city.getCname() + "&isfilter=1&p=1&pd=1";
                    city.setVal(AnalyzeZhaopin.zhaoPinNum(job_url, "UTF-8"));
                }
                strBody = JSON.toJSONString(cityList);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // 数据写入缓存
            ops.set(key, strBody, TIME_OUT, TimeUnit.SECONDS);
        }
        return strBody;
    }
}

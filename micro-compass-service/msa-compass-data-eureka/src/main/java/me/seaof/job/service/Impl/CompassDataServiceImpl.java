package me.seaof.job.service.Impl;

import me.seaof.job.common.JedisStateCode;
import me.seaof.job.service.CompassDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

/**
 * Created by Watter on 2018-02-28
 */
@Service
public class CompassDataServiceImpl implements CompassDataService {

    private final static Logger logger = LoggerFactory.getLogger(CompassDataServiceImpl.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取各个城市当天发布的职位信息数量
     * @return
     */
    @Override
    public String getDataByCity() throws Exception {

        String strBody = null;

        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        String key = JedisStateCode.ALL_JOB;
        if(stringRedisTemplate.hasKey(key)){
            logger.info("Redis has data!");
            strBody = ops.get(key);
        }else{
            logger.info("Redis don't has data!");
            throw new RuntimeException("don't has data!");
        }
        return strBody;
    }
}

package me.seaof.job.service.Impl;


import me.seaof.job.service.ZuulClient;
import me.seaof.job.service.CompassJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Watter on 2018-02-28
 */
@Service
public class CompassJobServiceImpl implements CompassJobService {

    private final static Logger logger = LoggerFactory.getLogger(CompassJobServiceImpl.class);


    @Autowired
    private ZuulClient zuulClient;

    /**
     * 获取各个城市当天发布的职位信息数量
     * @return
     */
    @Override
    public String getCityData() {
        try {
            return zuulClient.cityData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

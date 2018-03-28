package me.seaof.job.service.Impl;


import me.seaof.job.service.CompassDateClient;
import me.seaof.job.service.CompassJobService;
import me.seaof.job.vo.City;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Watter on 2018-02-28
 */
@Service
public class CompassJobServiceImpl implements CompassJobService {

    private final static Logger logger = LoggerFactory.getLogger(CompassJobServiceImpl.class);


    @Autowired
    private CompassDateClient compassDateClient;

    /**
     * 获取各个城市当天发布的职位信息数量
     * @return
     */
    @Override
    public String getCityData() {
        try {
            return compassDateClient.cityData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}

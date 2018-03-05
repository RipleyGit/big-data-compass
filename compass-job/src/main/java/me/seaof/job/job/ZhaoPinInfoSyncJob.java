package me.seaof.job.job;

import me.seaof.job.service.Impl.CityBaseDataServiceImpl;
import me.seaof.job.service.ZhaopinDataService;
import me.seaof.job.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Creat By Watter @DATA
 */
public class ZhaoPinInfoSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(ZhaoPinInfoSyncJob.class);

    @Autowired
    private ZhaopinDataService zhaopinDataService;

    @Autowired
    private CityBaseDataServiceImpl cityBaseDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("ZhaoPin Data Sync Job. Start！");

        List<City> list = cityBaseDataService.cityList();

        for (City city:list) {
            logger.info("Sync Data for :" + city.getCname());
            zhaopinDataService.syncDateByCityName(city);
        }

        logger.info("ZhaoPin Data Sync Job. End！");
    }
}

package me.seaof.job.job;

import me.seaof.job.service.CityClient;
import me.seaof.job.service.CompassDataCollectionService;
import me.seaof.job.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Creat By Watter @DATA
 */
public class CompassDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(CompassDataSyncJob.class);

    @Autowired
    private CompassDataCollectionService compassDataCollectionService;


    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info(" Compass Data Sync Job. Start！");

        compassDataCollectionService.syncDateByCityName();

        logger.info(" Compass Data Sync Job. End！");
    }
}

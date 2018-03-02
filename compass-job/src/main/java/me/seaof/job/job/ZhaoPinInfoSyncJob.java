package me.seaof.job.job;

import me.seaof.job.service.ZhaopinDataService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Creat By Watter @DATA
 */
public class ZhaoPinInfoSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(ZhaoPinInfoSyncJob.class);

    @Autowired
    private ZhaopinDataService zhaopinDataService;

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        logger.info("ZhaoPin Data Sync Job. Start！");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String data = df.format(new Date());

        try {
            zhaopinDataService.syncDateByCityName(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("ZhaoPin Data Sync Job. End！");
    }
}

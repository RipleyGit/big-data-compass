package me.seaof.job.config;

import me.seaof.job.job.ZhaoPinInfoSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 * Creat By Watter @DATA
 */
public class QuartzConfiguration {
    private static final int TIME = 28400; // 更新频率 8小时更新一次

    // JobDetail
    @Bean
    public JobDetail weatherDataSyncJobDetail() {
        return JobBuilder.newJob(ZhaoPinInfoSyncJob.class).withIdentity("zhaoPinDataSyncJob")
                .storeDurably().build();
    }

    // Trigger
    @Bean
    public Trigger weatherDataSyncTrigger() {

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(weatherDataSyncJobDetail())
                .withIdentity("zhaoPinDataSyncTrigger").withSchedule(schedBuilder).build();
    }
}

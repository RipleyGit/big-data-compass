package me.seaof.job.config;

import me.seaof.job.job.ZhaoPinInfoSyncJob;
import org.quartz.*;
import org.springframework.context.annotation.Bean;

/**
 * Creat By Watter @DATA
 */
public class QuartzConfiguration {
    private static final int TIME = 42000; // 更新频率

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

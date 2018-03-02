package me.seaof.job.config;

import me.seaof.job.job.ZhaoPinInfoSyncJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Creat By Watter @DATA
 */
@Configuration
public class QuartzConfiguration {
    private static final int TIME = 28400; // 更新频率 8小时更新一次

    // JobDetail
    @Bean
    public JobDetail DataSyncJobDetail() {
        return JobBuilder.newJob(ZhaoPinInfoSyncJob.class).withIdentity("zhaoPinDataSyncJob")
                .storeDurably().build();
    }

    // Trigger
    @Bean
    public Trigger weatherDataSyncTrigger() {

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(DataSyncJobDetail())
                .withIdentity("zhaoPinDataSyncTrigger").withSchedule(schedBuilder).build();
    }
}

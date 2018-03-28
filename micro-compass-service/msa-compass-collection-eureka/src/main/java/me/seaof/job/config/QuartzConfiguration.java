package me.seaof.job.config;

import me.seaof.job.job.CompassDataSyncJob;
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
    private static final int TIME = 10000; // 更新频率 8小时更新一次

    // JobDetail
    @Bean
    public JobDetail compassDataSyncJobDetail() {
        return JobBuilder.newJob(CompassDataSyncJob.class).withIdentity("compassDataSyncJob")
                .storeDurably().build();
    }

    // Trigger
    @Bean
    public Trigger compassDataSyncTrigger() {

        SimpleScheduleBuilder schedBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(TIME).repeatForever();

        return TriggerBuilder.newTrigger().forJob(compassDataSyncJobDetail())
                .withIdentity("compassDataSyncTrigger").withSchedule(schedBuilder).build();
    }
}

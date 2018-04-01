package me.seaof.job.service;

import org.springframework.stereotype.Component;

/**
 * Creat By Watter @DATA
 */
@Component
public class DataClientFallback implements ZuulClient{

    @Override
    public String cityData() {
        System.out.println("hello hystrix!");
        return "redis not data";
    }
}

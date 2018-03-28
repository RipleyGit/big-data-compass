package me.seaof.job.service;

import me.seaof.job.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by Watter on 2018-03-22
 */
@FeignClient("msa-compass-eureka-zuul")
public interface ZuulClient {
    @GetMapping("/city/cities")
    List<City> listCity() throws Exception;
}

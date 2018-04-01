package me.seaof.job.controller.view;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.seaof.job.service.ZuulClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creat By Watter @DATA
 */
@RestController
public class HelloContrller {

    @Autowired
    private ZuulClient zuulClient;

    @RequestMapping("/hello")
    @HystrixCommand(fallbackMethod = "defaultMethod")
    public String hello(){
        String str = null;
        try {
            str = zuulClient.cityData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(str);
        return str;
    }

    public String defaultMethod(){
        return "hello hystrix";
    }

}

package me.seaof.job.controller.rest;

import com.alibaba.fastjson.JSON;
import me.seaof.job.service.CompassJobService;
import me.seaof.job.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Watter on 2018-03-01
 */
@RestController
@RequestMapping("/getData")
public class JobRestController {

    @Autowired
    private CompassJobService compassJobService;

    @GetMapping("/allJobNum")
    public String allJobNum(){
        String str = compassJobService.getCityData();
        if("redis not data".equals(str)){
            System.out.println("into hystris");
            return null;
        }
        return compassJobService.getCityData();
    }
}

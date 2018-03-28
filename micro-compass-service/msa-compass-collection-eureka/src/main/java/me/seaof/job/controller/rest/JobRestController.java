package me.seaof.job.controller.rest;

import com.alibaba.fastjson.JSON;
import me.seaof.job.service.CityClient;
import me.seaof.job.service.CompassDataCollectionService;
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
public class JobRestController {

    @Autowired
    private CompassDataCollectionService compassDataCollectionService;



    @GetMapping("/getData")
    public String allJobNum(){
        return null;

    }
}

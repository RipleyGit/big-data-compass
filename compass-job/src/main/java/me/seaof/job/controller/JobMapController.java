package me.seaof.job.controller;

import com.alibaba.fastjson.JSON;
import me.seaof.job.service.ZhaopinDataService;
import me.seaof.job.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Watter on 2018-02-28
 */
@RestController
@RequestMapping("/job")
public class JobMapController {

    @Autowired
    private ZhaopinDataService zhaopinDataService;

    @GetMapping("/map")
    public ModelAndView jobMap(){
        return new ModelAndView("job/job-map");
    }

    @GetMapping("/mapData")
    public String mapData(){
        return zhaopinDataService.getDataByCity();

    }
}

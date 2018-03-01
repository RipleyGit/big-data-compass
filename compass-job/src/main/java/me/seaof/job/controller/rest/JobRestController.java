package me.seaof.job.controller.rest;

import me.seaof.job.service.ZhaopinDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Watter on 2018-03-01
 */
@RestController
@RequestMapping("/getData")
public class JobRestController {

    @Autowired
    private ZhaopinDataService zhaopinDataService;

    @GetMapping("/allJobNum")
    public String allJobNum(){
        return zhaopinDataService.getDataByCity();

    }
}

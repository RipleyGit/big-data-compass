package me.seaof.job.controller.rest;

import me.seaof.job.service.CompassDataCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

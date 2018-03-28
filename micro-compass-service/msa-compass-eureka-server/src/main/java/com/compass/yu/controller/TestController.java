package com.compass.yu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Watter on 2018-03-22
 */
@RestController
public class TestController {
    @GetMapping("/hello/{str}")
    public String getStr(@PathVariable("str")String str){
        return str;
    }
}

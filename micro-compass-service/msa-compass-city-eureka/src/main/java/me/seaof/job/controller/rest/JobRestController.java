package me.seaof.job.controller.rest;

import com.alibaba.fastjson.JSON;
import me.seaof.job.service.CityBaseDataService;
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
@RequestMapping("/cities")
public class JobRestController {

    @Autowired
    private CityBaseDataService cityBaseDataService;

    @GetMapping
    public List<City> listCity(){
        return cityBaseDataService.cityList();
    }
}

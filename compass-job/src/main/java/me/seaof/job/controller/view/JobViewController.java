package me.seaof.job.controller.view;

import me.seaof.job.service.ZhaopinDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Watter on 2018-03-01
 */
@Controller
@RequestMapping("/job")
public class JobViewController {
    @Autowired
    private ZhaopinDataService zhaopinDataService;

    @GetMapping("/map")
    public ModelAndView jobMap(){
        return new ModelAndView("job/job-map");
    }
}

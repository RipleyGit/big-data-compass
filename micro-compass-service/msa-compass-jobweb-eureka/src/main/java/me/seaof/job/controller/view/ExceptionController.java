package me.seaof.job.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Creat By Watter @DATA
 */
@Controller
@RequestMapping("/exception")
public class ExceptionController {
    @RequestMapping("/error")
    public ModelAndView toError(){
        return new ModelAndView("/exception/error");
    }
}

package com.manong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author APPLE
 * @author 2019-05-07 下午8:19
 * @description FreeMarker与SpringMVC整合
 */
@Controller
public class FreeMarkerTestController {
    @RequestMapping("/hello")
    public String SayHello(Model model){
        model.addAttribute("name","wistChen");
        return "hello";
    }

    @RequestMapping("/hi")
    public String SayHi(Model model){
        model.addAttribute("name","wistChen");
        return "hi";
    }

}

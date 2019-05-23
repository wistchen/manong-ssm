package com.manong.portal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author APPLE
 * @author 2019-05-12 下午10:11
 * @description 整合FreeMarker模板引擎
 */
@Controller
public class FreemarkerTest {
    @RequestMapping("/hello")
    public String sayHello(Model model){
        model.addAttribute("name","wistChen");
        return "hello";
    }
}

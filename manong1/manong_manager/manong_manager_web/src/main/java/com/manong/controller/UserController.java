package com.manong.controller;

import com.manong.pojo.User;
import com.manong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 测试
 *
 * @author APPLE
 * @author 2019-4-20 下午9:50
 */
@Controller
public class UserController {


    @Autowired
    UserService userService;

    @RequestMapping("/user/{userid}")
    @ResponseBody
    public User getUserById(@PathVariable Integer userid){
        User user = userService.getUserById(userid);
        System.out.println(user.getUsername());
        return user;
    }

//    @Autowired
//    UserService userService;
//
//    @RequestMapping("/user/{userid}")
//    @ResponseBody
//    public User getUserById(@PathVariable Integer userid){
//        User user = userService.getUserById(userid);
//        System.out.println(user.getUsername());
//        return user;
//    }
}

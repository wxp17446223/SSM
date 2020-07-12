package cn.com.controller;

import cn.com.bean.UserInfo;
import cn.com.service.UserInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class HelloController {

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String hello(){
        System.out.println("hello");
        return "login";
    }
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(){
        return "index";
    }



}

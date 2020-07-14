package cn.com.controller;

import cn.com.bean.RequestParamCollection;
import cn.com.bean.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;

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

    //RestFul
    @RequestMapping("/p5/{year}/{mouth}/{day}")
    public String p5(@PathVariable int year , @PathVariable int mouth, @PathVariable int day) {
        System.out.format("%s-%s-%d", year, mouth, day);
        return "index";
    }
    //参数传递
    @GetMapping("/p1")
    public String p1(HttpServletRequest request){
        String name=request.getParameter("name");
        System.out.println("name = " + name);
        return "index";
    }
    @GetMapping("/p2")
    public String p2(String name,@RequestParam(defaultValue = "0") int age){
        //传参的时候 没传age会报500错误 基本数据类型不能为null  Integer就可以
        //或者加了@RequestParam(defaultValue = "0")注解就是必填 可以设默认值
        //使用了defaultValue值的话 它的required（）默认值为false  本来是true
        System.out.println("name = " + name+",age="+age);
        return "index";
    }
    @GetMapping("/p3")
    public String p3(int[]ids){
        //localhost/p3?ids=1&ids=2&ids=3
        System.out.println("ids = " + Arrays.toString(ids));
        return "index";
    }

    @GetMapping("/p4")
    public String p4(UserInfo userInfo){
        //localhost/p3?userName=123&password=123412
        //会自动封装成对象
        System.out.println("userInfo = " + userInfo);
        return "index";
    }

    @GetMapping("/p5")
    public String p5(@ModelAttribute("userInfo") UserInfo userInfo,@ModelAttribute("createBy") UserInfo createBy){
        //localhost/p3?userName=123&password=123412  结果是两个一样
        //会自动封装成对象
        //localhost/p3?userName=123&password=123412&userName=321&password=2222  结果会是字符串的拼接

        //用到动态绑定  @InitBinder("userInfo") @ModelAttribute("userInfo") 只要一致
        //FieldDefaultPrefix("userInfo.")  QueryString 值一致
        //localhost/p3?userInfo.userName=123&userInfo.password=123412&createBy.userName=321&createBy.password=2222
        System.out.println("userInfo = " + userInfo);
        System.out.println("createBy = " + createBy);
        return "index";
    }
    //动态绑定
    @InitBinder("userInfo")
    public void bindUserInfo(WebDataBinder binder){
        binder.setFieldDefaultPrefix("userInfo.");
    }
    @InitBinder("createBy")
    public void bindCreateBy(WebDataBinder binder){
        binder.setFieldDefaultPrefix("createBy.");
    }


    @GetMapping("/p6")
    //传递集合的方式 需要创建一个类RequestParamCollection
    public String p6(RequestParamCollection collection) {
        //localhost/p6?set=1&set=2&set=3
        //localhost/p6?list[0]=1&list[1]=2&list[2]=3
        //localhost/p6?map[userName]=admin&map[password]=123
        System.out.println("collection = " + collection);
        return "index";
    }

    @GetMapping("/p7")
    public String p7(ModelMap model) {
        model.addAttribute("date",new Date().toLocaleString());
        return "index";
    }

    @GetMapping("/p8")
    public ModelAndView p8(){
        ModelAndView modelAndView=new ModelAndView("index");
        modelAndView.addObject("date",new Date().toLocaleString());
        return modelAndView;
    }

    @GetMapping("/p9")
    public String p9(@ModelAttribute("userInfo") UserInfo userInfo) {
        //localhost/p9?userName=admin   结果会是跟下面的数据合并输出来@ModelAttribute("userInfo")映射到下面
        //下面代码会先执行 在使用@ModelAttribute("userInfo") 取出来放进本身这个对象中
        //这是特性 自动合并
        System.out.println("userInfo = " + userInfo);
        return "index";
    }

    @ModelAttribute
    public UserInfo a() {
        //跟下面代码等价
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword("123");
        return userInfo;
    }
    @ModelAttribute
    public void b(ModelMap modelMap) {
        //跟上面代码等价
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword("123");
        modelMap.addAttribute("userInfo",userInfo);
    }


}

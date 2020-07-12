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
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserInfoService userInfoService;

    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public String find(UserInfo userInfo, ModelMap modelMap){
        List<UserInfo> list = userInfoService.findAll(userInfo);
        modelMap.addAttribute("list",list);
        return "index";
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public String saveGet(Integer id, ModelMap modelMap){
        if (id!=null) {
            UserInfo user = userInfoService.selectByPrimaryKey(id);
            modelMap.addAttribute("user",user);
        }
        return "save";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String savePost(UserInfo userInfo, ModelMap modelMap){
        if (userInfo.getId()!=null){
            int i = userInfoService.updateByPrimaryKeySelective(userInfo);
            if (i>0) {
                modelMap.addAttribute("msg","修改成功！");
            }else {
                modelMap.addAttribute("msg","修改失败！");
            }
        }else {
            int i = userInfoService.insertSelective(userInfo);
            if (i>0) {
                modelMap.addAttribute("msg","新增成功！");
            }else {
                modelMap.addAttribute("msg","新增失败！");
            }
        }
        List<UserInfo> list = userInfoService.findAll(null);
        modelMap.addAttribute("list",list);
        return "index";
    }

    @RequestMapping(value = "/del")
    public String del(Integer[] ids, ModelMap modelMap){
        int i = userInfoService.delByIds(ids);
        if (i>0) {
            modelMap.addAttribute("msg","删除成功！");
        }else {
            modelMap.addAttribute("msg","删除失败！");
        }
        List<UserInfo> list = userInfoService.findAll(null);
        modelMap.addAttribute("list",list);
        return "index";
    }


}

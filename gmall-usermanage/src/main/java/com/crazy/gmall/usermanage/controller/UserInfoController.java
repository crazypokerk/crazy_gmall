package com.crazy.gmall.usermanage.controller;

import com.crazy.gmall.bean.UserInfo;
import com.crazy.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

//    @ResponseBody : 返回Json 字符串，将数据显示在页面上
    @RequestMapping("findAll")
    @ResponseBody
    public List<UserInfo> getAll(){
        // ctrl+alt+b 进入实现类
      return   userInfoService.findAll();
    }

    /*
        bean : 实体类，
        interface：接口 - 除了mapper ， mapper放在当前的项目中！
        common - web service
        web ：搭建页面项目的时候，使用web-util，
        service ：搭建项目后台服务需要使用
     */


}

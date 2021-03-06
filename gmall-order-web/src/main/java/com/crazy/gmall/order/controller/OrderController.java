package com.crazy.gmall.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crazy.gmall.bean.UserAddress;
import com.crazy.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderController {

    // 在订单项目中，调用usermanage项目中 根据userId查询userAddress方法
//    @Autowired
    @Reference
    private UserInfoService userInfoService;
    
    @RequestMapping("trade")
    @ResponseBody
    public List<UserAddress> getUserAddress(String userId){

        List<UserAddress> userAddressList = userInfoService.getUserAddressList(userId);

        return userAddressList;
    }

    // private UserAddressService userAddressService;

}

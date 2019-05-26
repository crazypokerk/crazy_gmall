package com.crazy.gmall.service;

import com.crazy.gmall.bean.UserAddress;
import com.crazy.gmall.bean.UserInfo;

import java.util.List;

public interface UserInfoService {
  // alt+enter
  List<UserInfo> findAll();
  // 根据userId 查询用户地址列表
  List<UserAddress> getUserAddressList(String userId);

  UserInfo login(UserInfo userInfo);
}

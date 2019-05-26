package com.crazy.gmall.usermanage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.crazy.gmall.bean.UserAddress;
import com.crazy.gmall.bean.UserInfo;
import com.crazy.gmall.config.RedisUtil;
import com.crazy.gmall.service.UserInfoService;
import com.crazy.gmall.usermanage.mapper.UserAddressMapper;
import com.crazy.gmall.usermanage.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import redis.clients.jedis.Jedis;


import java.util.List;

@Service
public class UserInfoServiceImpl implements UserInfoService {
  // 定义用户信息
  public String userKey_prefix = "user:";
  public String userinfoKey_suffix = ":info";
  public int userKey_timeOut = 60 * 60;

  @Autowired
  private RedisUtil redisUtil;

  @Autowired
  private UserInfoMapper userInfoMapper;

  @Autowired
  private UserAddressMapper userAddressMapper;

  @Override
  public List<UserInfo> findAll() {
    return userInfoMapper.selectAll();
  }

  @Override
  public List<UserAddress> getUserAddressList(String userId) {
    UserAddress userAddress = new UserAddress();
    userAddress.setUserId(userId);
    // ctrl+alt+v 自动补全
    List<UserAddress> select = userAddressMapper.select(userAddress);
    return select;
  }

  @Override
  public UserInfo login(UserInfo userInfo) {
    // 页面传递 admin  -- 123
    // db   admin -- 202cb962ac59075b964b07152d234b70
    // 将 123 加密
    String passwd = userInfo.getPasswd();
    // 123 -- 202cb962ac59075b964b07152d234b70
    String newPwd = DigestUtils.md5DigestAsHex(passwd.getBytes());
    userInfo.setPasswd(newPwd);
    //根据用户名和加密后的密码从DB中找是否存在
    UserInfo info = userInfoMapper.selectOne(userInfo);
    // 如果用户登录成功则将用户信息存放到redis

    if (info != null) {
      Jedis jedis = redisUtil.getJedis();
      try {
        // 定义key：user:1:info
        String userKey = userKey_prefix + info.getId() + userinfoKey_suffix;
        // 做存储
        jedis.setex(userKey, userKey_timeOut, JSON.toJSONString(info));
      } finally {
        jedis.close();
      }
      return info;
    }
    return null;
  }
}

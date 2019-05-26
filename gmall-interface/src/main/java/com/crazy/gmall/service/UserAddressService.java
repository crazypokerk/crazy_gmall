package com.crazy.gmall.service;

import com.crazy.gmall.bean.UserAddress;

import java.util.List;

public interface UserAddressService {

  List<UserAddress> findByUserId(String userId);

}


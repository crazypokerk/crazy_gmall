package com.crazy.gmall.passport.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crazy.gmall.bean.UserInfo;
import com.crazy.gmall.passport.util.JwtUtil;
import com.crazy.gmall.service.UserInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * @Date 2019/5/25 15:47
 */
@Controller
public class PassportController {

  @Value("${token.key}")
  private String key;

  @Reference
  UserInfoService userInfoService;

  @RequestMapping("index")
  public String login(HttpServletRequest request) {
    String originUrl = request.getParameter("originUrl");
    request.setAttribute("originUrl", originUrl);
    return "index";
  }

  @RequestMapping(value = "login")
  @ResponseBody
  public String login(UserInfo userInfo, HttpServletRequest request) {
    String ip = request.getHeader("X-forwarded-for");
    UserInfo loginUser = userInfoService.login(userInfo);

    if (loginUser != null) {
      //生成token
      HashMap<String, Object> map = new HashMap<>();
      map.put("userId", loginUser.getId());
      map.put("nickName", loginUser.getNickName());

      String token = JwtUtil.encode(key, map, ip);
      return token;
    } else {
      return "fail";
    }
  }
}

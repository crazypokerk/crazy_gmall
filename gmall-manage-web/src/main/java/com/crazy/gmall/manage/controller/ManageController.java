package com.crazy.gmall.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Date 2019/5/17 10:26
 */
@Controller
public class ManageController {
  @RequestMapping("index")
  public String index() {
    return "index";
  }

  @RequestMapping("attrListPage")
  public String attrListPage(){
    return "attrListPage";
  }
}

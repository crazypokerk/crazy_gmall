package com.crazy.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crazy.gmall.bean.*;
import com.crazy.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 平台属性的数据展示放在AttrManageController
@Controller
public class AttrManageController {

  @Reference
  private ManageService manageService;
  // 因为easyUI 控件是基于Json格式数据，所以返回Json数据
  @RequestMapping("getCatalog1")
  @ResponseBody
  public List<BaseCatalog1> getCatalog1(){
    // 调用服务层查询所有数据。
    return manageService.getCatalog1();
  }
  @RequestMapping("getCatalog2")
  @ResponseBody
  public List<BaseCatalog2> getCatalog2(String catalog1Id){
    // 调用服务层查询所有数据。
    return manageService.getCatalog2(catalog1Id);
  }

  @RequestMapping("getCatalog3")
  @ResponseBody
  public List<BaseCatalog3> getCatalog3(String catalog2Id){
    // 调用服务层查询所有数据。
    return manageService.getCatalog3(catalog2Id);
  }

  @RequestMapping("attrInfoList")
  @ResponseBody
  public List<BaseAttrInfo> attrInfoList(String catalog3Id){
    // 调用服务层查询所有数据。
    return manageService.getAttrList(catalog3Id);
  }

  @RequestMapping("saveAttrInfo")
  @ResponseBody
  public void saveAttrInfo(BaseAttrInfo baseAttrInfo){
    manageService.saveAttrInfo(baseAttrInfo);
  }

  @RequestMapping("getAttrValueList")
  @ResponseBody
  public List<BaseAttrValue> getAttrValueList(String attrId){
    // 根据平台属性名称Id 查询到BaseAttrInfo 对象
    BaseAttrInfo baseAttrInfo = manageService.getAttrInfo(attrId);
    return  baseAttrInfo.getAttrValueList();
  }
}


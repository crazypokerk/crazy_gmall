package com.crazy.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crazy.gmall.bean.BaseAttrInfo;
import com.crazy.gmall.bean.BaseSaleAttr;
import com.crazy.gmall.bean.SpuInfo;
import com.crazy.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Date 2019/5/18 9:22
 */
@Controller
public class SpuManageController {
  @Reference
  private ManageService manageService;

  @RequestMapping("spuListPage")
  public String spuListPage(){
    return "spuListPage";
  }

  // select * from spuInfo where catalog3Id = ?
  @RequestMapping("spuList")
  @ResponseBody
  public List<SpuInfo> spuList(String catalog3Id){
    // 调用后台
    SpuInfo spuInfo = new SpuInfo();
    spuInfo.setCatalog3Id(catalog3Id);
    return  manageService.getSpuInfoList(spuInfo);
  }

  @RequestMapping("baseSaleAttrList")//与前端supSaleAttrPage.html 中的 url:'baseSaleAttrList' 相对应
  @ResponseBody
  public List<BaseSaleAttr> getBaseSaleAttrList() {
    //调用service层
    List<BaseSaleAttr> baseSaleAttrList = manageService.getBaseSaleAttrList();
    return baseSaleAttrList;
  }

  @RequestMapping(value = "saveSpuInfo",method = RequestMethod.POST)
  @ResponseBody
  public String saveSpuInfo(SpuInfo spuInfo){
    // 调用服务层进行添加数据 alt+enter
    manageService.saveSpuInfo(spuInfo);
    return "success";
  }
}

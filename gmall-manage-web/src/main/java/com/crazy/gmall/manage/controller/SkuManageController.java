package com.crazy.gmall.manage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.crazy.gmall.bean.SkuInfo;
import com.crazy.gmall.bean.SpuImage;
import com.crazy.gmall.bean.SpuSaleAttr;
import com.crazy.gmall.service.ManageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Date 2019/5/20 10:55
 */
@Controller
public class SkuManageController {
  @Reference
  private ManageService manageService;

  @RequestMapping("spuImageList")
  @ResponseBody
  public List<SpuImage> spuImageList(String spuId) {
    // 调用服务层查询数据
    return manageService.getSpuImageList(spuId);
  }
  @RequestMapping("spuSaleAttrList")
  @ResponseBody
  public List<SpuSaleAttr> spuSaleAttrList(String spuId) {
    return manageService.getSpuSaleAttrList(spuId);
  }

  @RequestMapping(value = "saveSku", method = RequestMethod.POST)
  @ResponseBody
  public void saveSku(SkuInfo skuInfo) {
    manageService.saveSku(skuInfo);
  }
}

package com.crazy.gmall.manage.mapper;


import com.crazy.gmall.bean.SkuSaleAttrValue;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SkuSaleAttrValueMapper extends Mapper<SkuSaleAttrValue> {
  // 根据spuId查询销售属性值Id
  List<SkuSaleAttrValue> selectSkuSaleAttrValueListBySpu(String spuId);
}

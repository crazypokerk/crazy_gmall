package com.crazy.gmall.manage.mapper;


import com.crazy.gmall.bean.BaseAttrInfo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface BaseAttrInfoMapper extends Mapper<BaseAttrInfo> {

  // 根据三级分类Id进行查询 List<BaseAttrInfo>
  List<BaseAttrInfo> getBaseAttrInfoListByCatalog3Id(Long catalog3Id);
}

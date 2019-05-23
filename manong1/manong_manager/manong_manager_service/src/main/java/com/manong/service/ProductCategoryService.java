package com.manong.service;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

public interface ProductCategoryService {

    List<EasyUITree> findProductCategoryListByParentId(Short parentid);

    ResponseJsonResult addCategory(Short parentid,String name);

    ResponseJsonResult deleteCategory(Short parentid,Short id);

    ResponseJsonResult editCategory(Short parentid,Short id,String name);

//    增加分类
//    ResponseJsonResult addCategoryDemo(Short parentid,String name);

}

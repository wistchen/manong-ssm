package com.manong.controller;

import com.manong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

/**
 * 商品分类管理
 *
 * @author APPLE
 * @author 2019-4-25 上午10:44
 */
@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> findProductCategoryListByParentId(@RequestParam(value="id",defaultValue = "0") Short parentid){
        List<EasyUITree> list = productCategoryService.findProductCategoryListByParentId(parentid);
        return list;
    }

    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCategory(Short parentId, String name){

        ResponseJsonResult responseJsonResult = productCategoryService.addCategory(parentId, name);
        return responseJsonResult;
    }


//    @RequestMapping("/adddemo")
//    @ResponseBody
//    public ResponseJsonResult addCategoryDemo(Short parentId, String name){
//
//        ResponseJsonResult responseJsonResult = productCategoryService.addCategory(parentId, name);
//
//
//        return responseJsonResult;
//    }

    @RequestMapping("/del")
    @ResponseBody
    public ResponseJsonResult deleteCategory(Short parentId, Short id){
        ResponseJsonResult responseJsonResult = productCategoryService.deleteCategory(parentId, id);
        return responseJsonResult;

    }

    @RequestMapping("/edit")
    @ResponseBody
    public ResponseJsonResult editCategory(Short parentId,Short id, String name){
        ResponseJsonResult responseJsonResult = productCategoryService.editCategory(parentId, id, name);
        return responseJsonResult;

    }

//    @RequestMapping("/list")
//    @ResponseBody
////    参数名字不一致的话，需要在@RequestParam后面指定参数名字，才能为后面的参数进行赋值。
//    public List<EasyUITree> findProductCategoryListByParentId(@RequestParam(value="id",defaultValue = "0") Short parentid){
//        List<EasyUITree> list = productCategoryService.findProductCategoryListByParentId(parentid);
//        System.out.println(list);
//        return list;
//    }
}

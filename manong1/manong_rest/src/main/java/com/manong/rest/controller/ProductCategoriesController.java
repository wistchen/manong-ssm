package com.manong.rest.controller;

import com.manong.rest.service.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Res_Categories;

/**
 * @author APPLE
 * @author 2019-05-13 下午8:14
 * @description 商品分类
 */
@Controller
@RequestMapping("/rest")
public class ProductCategoriesController {
    @Autowired
    private ProductCategoriesService productCategoriesService;

    @RequestMapping("productCategories/list")
    @ResponseBody
    public Res_Categories getCategories(){
        Res_Categories categories = productCategoriesService.getCategories();
        return categories;
    }
}

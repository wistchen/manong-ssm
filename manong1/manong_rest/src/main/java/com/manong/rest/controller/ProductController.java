package com.manong.rest.controller;

import com.manong.rest.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.ResponseJsonResult;

/**
 * @author APPLE
 * @author 2019-05-14 下午4:38
 * @description 商品
 */
@Controller
@RequestMapping("/rest")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("product/list")
    @ResponseBody
    public ResponseJsonResult getProduct(){
        ResponseJsonResult responseJsonResult = productService.getProduct();
        return responseJsonResult;
    }
}

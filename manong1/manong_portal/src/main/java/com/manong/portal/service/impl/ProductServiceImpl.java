package com.manong.portal.service.impl;

import com.manong.portal.service.ProductService;
import com.manong.portal.util.GsonUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pojo.Res_Product;
import pojo.ResponseJsonResult;
import utils.HttpClientUtil;

import java.io.IOException;
import java.util.List;

/**
 * @author APPLE
 * @author 2019-05-14 下午7:33
 * @description 商品
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Value("${REST_URL}")
    private String REST_URL;

//    @Value("{REST_PRODUCT_LIST}") 少了个$
    @Value("${REST_PRODUCT_LIST}")
    private String REST_PRODUCT_LIST;


    @Override
    public List<Res_Product> getProducts() {

        try {
            String jsonResult = HttpClientUtil.httpGet(REST_URL + REST_PRODUCT_LIST);
            ResponseJsonResult responseJsonResult = GsonUtils.fromJson(ResponseJsonResult.class, jsonResult);
            List<Res_Product> list = (List<Res_Product>) responseJsonResult.getList();
            return list;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

//    @Value("${REST_URL}")
//    private String REST_URL;
//
//    @Value("{REST_PRODUCT_LIST}")
//    private String REST_PRODUCT_LIST;
//
//    @Override
//    public List<Res_Product> getProducts() {
//        try {
//            String jsonResult = HttpClientUtil.httpGet(REST_URL + REST_PRODUCT_LIST);
//            System.out.println(jsonResult);
//            ResponseJsonResult responseJsonResult = GsonUtils.fromJson(ResponseJsonResult.class, jsonResult);
//            List<Res_Product> list = (List<Res_Product>) responseJsonResult.getList();
//            return list;
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
}

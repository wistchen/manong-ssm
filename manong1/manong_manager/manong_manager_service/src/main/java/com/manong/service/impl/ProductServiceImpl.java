package com.manong.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.manong.mapper.ProductMapper;
import com.manong.pojo.Product;
import com.manong.pojo.ProductExample;
import com.manong.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyGrid;
import pojo.ResponseJsonResult;

import java.util.List;

/**
 * @author APPLE
 * @author 2019-05-10 上午10:47
 * @description 产品
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    public ResponseJsonResult saveProduct(Product product) {
//        product.setStatus((byte) 1);
        productMapper.insert(product);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);

        return responseJsonResult;
    }

    @Override
    public EasyGrid listProduct(int pages, int rows) {
        ProductExample productExample = new ProductExample();
//        确定一页几条
        PageHelper.startPage(pages,rows);
//        选出当前信息
        List<Product> productList = productMapper.selectByExample(productExample);
//        分页信息
        PageInfo<Product> pageInfo = new PageInfo<>(productList);

        EasyGrid easyGrid = new EasyGrid();
        easyGrid.setTotal((int) pageInfo.getTotal());
        easyGrid.setRows(productList);

        return easyGrid;
    }
}

package com.manong.service.impl;

import com.manong.mapper.ProductCategoryMapper;
import com.manong.pojo.Product;
import com.manong.pojo.ProductCategory;
import com.manong.pojo.ProductCategoryExample;
import com.manong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.ArrayList;
import java.util.List;

/**
 * @author APPLE
 * @author 2019-4-25 上午10:31
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public List<EasyUITree> findProductCategoryListByParentId(Short parentid) {

        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(parentid);

//      通过parentid找出productCategory用集合装载
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);
//      定义一个集合来装载EasyUITree
        List<EasyUITree> list = new ArrayList<>(productCategoryList.size());

        for(ProductCategory productCategory:productCategoryList){
            EasyUITree tree = new EasyUITree();
            tree.setId(productCategory.getId());
            tree.setText(productCategory.getName());
            tree.setState(productCategory.getParentId()==0?"closed":"open");
//            删除需要的属性
            tree.setAttributes(productCategory.getParentId()+"");
            list.add(tree);
        }
        return list;
    }

    @Override
    public ResponseJsonResult addCategory(Short parentid, String name) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentId(parentid);
        productCategory.setName(name);

        productCategoryMapper.insert(productCategory);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setMsg(productCategory.getId()+" ");

        return responseJsonResult;
    }

    @Override
    public ResponseJsonResult deleteCategory(Short parentid, Short id) {
//        用一个productCategoryExample 创建两个 criteria
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();

        if(parentid == 0){
//            如果是父级 则要把id=id 和 parentid=id 找出来再删除
            criteria.andIdEqualTo(id);
            ProductCategoryExample.Criteria criteria1 = productCategoryExample.createCriteria();
            criteria1.andParentIdEqualTo(id);
        }else{
//            如果不是父级则删除id=id
            criteria.andIdEqualTo(id);
        }
        productCategoryMapper.deleteByExample(productCategoryExample);

        ResponseJsonResult result = new ResponseJsonResult();
        result.setStatus(200);
        result.setMsg("success");
        return result;
    }

    @Override
    public ResponseJsonResult editCategory(Short parentid,Short id, String name) {


        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        productCategory.setName(name);
        productCategory.setParentId(parentid);

        productCategoryMapper.updateByPrimaryKey(productCategory);

        ResponseJsonResult responseJsonResult = new ResponseJsonResult();
        responseJsonResult.setStatus(200);
        responseJsonResult.setMsg("success");

        return responseJsonResult;

    }

}

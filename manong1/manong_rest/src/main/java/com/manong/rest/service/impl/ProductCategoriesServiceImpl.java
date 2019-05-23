package com.manong.rest.service.impl;

import com.manong.mapper.ProductCategoryMapper;
import com.manong.pojo.ProductCategory;
import com.manong.pojo.ProductCategoryExample;
import com.manong.rest.service.ProductCategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Res_Categories;

import java.util.ArrayList;
import java.util.List;

/**
 * @author APPLE
 * @author 2019-05-13 下午7:34
 * @description 商品分类
 */
@Service
public class ProductCategoriesServiceImpl implements ProductCategoriesService {
    @Autowired
    ProductCategoryMapper productCategoryMapper;

    @Override
    public Res_Categories getCategories() {
        Res_Categories res_categories = new Res_Categories();
        //查询商品分类 parentId = 0
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo((short) 0);
        List<ProductCategory> productCategories = productCategoryMapper.selectByExample(productCategoryExample);
        //  数组 外套
        List<Res_Categories.CategoriesBean> categories = new ArrayList<>();

        for (int i = 0; i < productCategories.size(); i++) {
            //里面对象
            Res_Categories.CategoriesBean categoriesBean = new Res_Categories.CategoriesBean();
            //获取分类信息
            ProductCategory productCategory = productCategories.get(i);
            categoriesBean.setName(productCategory.getName());
            categoriesBean.setCat_id(productCategory.getId()+"");

            //通过Id获取子分类
            List<Res_Categories.CategoriesBean.SubCetegoriesBean> SubCategoriesBean = getSubCategories(productCategory.getId());
            categoriesBean.setSub_cetegories(SubCategoriesBean);
            //对象加入容器中
            categories.add(categoriesBean);
        }
        res_categories.setCategories(categories);
        return res_categories;
    }

    private List<Res_Categories.CategoriesBean.SubCetegoriesBean> getSubCategories(Short id) {
        //用一个集合来装子分类
        ArrayList<Res_Categories.CategoriesBean.SubCetegoriesBean> list = new ArrayList<>();
        //查询
        ProductCategoryExample productCategoryExample = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = productCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(id);
        List<ProductCategory> productCategoryList = productCategoryMapper.selectByExample(productCategoryExample);
        // 循环给subCetegoriesBean对象赋值并加入到集合容器中
        for (int i = 0; i < productCategoryList.size() ; i++) {
            Res_Categories.CategoriesBean.SubCetegoriesBean subCetegoriesBean = new Res_Categories.CategoriesBean.SubCetegoriesBean();

            ProductCategory productCategory = productCategoryList.get(i);
            subCetegoriesBean.setCat_id(productCategory.getId()+"");
            subCetegoriesBean.setName(productCategory.getName());

            list.add(subCetegoriesBean);
        }
        return list;
    }
}

package com.liujiaohan.sell.repository;

import com.liujiaohan.sell.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {
    protected final org.slf4j.Logger logger= LoggerFactory.getLogger(ProductCategoryRepositoryTest.class);

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void findOneTest(){
        ProductCategory productCategory=productCategoryRepository.findOne(1);
        logger.info(productCategory.toString());
    }

    @Test
    public void saveTest(){
        ProductCategory productCategory=new ProductCategory();
        productCategory.setCategoryName("甜品");
        productCategory.setCategoryType(3);
        productCategoryRepository.save(productCategory);
        ProductCategory productCategory1=new ProductCategory();
        productCategory1.setCategoryName("小吃");
        productCategory1.setCategoryType(1);
        productCategoryRepository.save(productCategory1);
        ProductCategory productCategory2=new ProductCategory();
        productCategory2.setCategoryName("饮料");
        productCategory2.setCategoryType(2);
        productCategoryRepository.save(productCategory2);
    }
}
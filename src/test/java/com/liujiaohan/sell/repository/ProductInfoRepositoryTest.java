package com.liujiaohan.sell.repository;

import com.liujiaohan.sell.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() throws Exception {
        Assert.assertNotNull(productInfoRepository.findByProductStatus(0));
    }

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();

        productInfo.setProductId("545");
        productInfo.setCategoryType(1);
        productInfo.setProductDescription("好吃的");
        productInfo.setProductIcon("www.baidu.com");
        productInfo.setProductName("鸡蛋");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStatus(1);
        productInfo.setProductStock(100);

        ProductInfo result=productInfoRepository.save(productInfo);
        Assert.assertNotNull(result);
    }
}
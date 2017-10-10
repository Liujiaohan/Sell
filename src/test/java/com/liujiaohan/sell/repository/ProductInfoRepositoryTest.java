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
  //      Assert.assertNotNull(productInfoRepository.findByProductStatus(0));
    }

    @Test
    public void saveTest(){
        ProductInfo productInfo=new ProductInfo();

        productInfo.setProductId("321");
        productInfo.setCategoryType(2);
        productInfo.setProductDescription("好吃的");
        productInfo.setProductIcon("www.baidu.com");
        productInfo.setProductName("可乐");
        productInfo.setProductPrice(new BigDecimal(3.2));
        productInfo.setProductStatus(0);
        productInfo.setProductStock(100);

        ProductInfo result=productInfoRepository.save(productInfo);

        ProductInfo productInfo1=new ProductInfo();

        productInfo1.setProductId("123");
        productInfo1.setCategoryType(1);
        productInfo1.setProductDescription("好吃的");
        productInfo1.setProductIcon("www.baidu.com");
        productInfo1.setProductName("蛋炒饭");
        productInfo1.setProductPrice(new BigDecimal(3.2));
        productInfo1.setProductStatus(0);
        productInfo1.setProductStock(100);

        ProductInfo result1=productInfoRepository.save(productInfo1);

        ProductInfo productInfo2=new ProductInfo();

        productInfo2.setProductId("231");
        productInfo2.setCategoryType(3);
        productInfo2.setProductDescription("好吃的");
        productInfo2.setProductIcon("www.baidu.com");
        productInfo2.setProductName("雪糕");
        productInfo2.setProductPrice(new BigDecimal(3.2));
        productInfo2.setProductStatus(0);
        productInfo2.setProductStock(100);

        ProductInfo result2=productInfoRepository.save(productInfo2);
        Assert.assertNotNull(result2);
    }
}
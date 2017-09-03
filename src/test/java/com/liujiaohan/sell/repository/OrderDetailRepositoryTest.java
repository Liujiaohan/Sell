package com.liujiaohan.sell.repository;

import com.liujiaohan.sell.dataobject.OrderDetail;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.security.PrivateKey;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRepositoryTest {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void findByOrderId() throws Exception {
    }

    @Test
    public void save(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDetailId("123456");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("www.baidu.com");
        orderDetail.setProductId("123");
        orderDetail.setProductName("蛋炒饭");
        orderDetail.setProductPrice(new BigDecimal(3.20));
        orderDetail.setProductQuantity(2);
        orderDetailRepository.save(orderDetail);

        OrderDetail orderDetail1=new OrderDetail();
        orderDetail1.setDetailId("21654");
        orderDetail1.setOrderId("123456");
        orderDetail1.setProductIcon("www.baidu.com");
        orderDetail1.setProductId("321");
        orderDetail1.setProductName("可乐");
        orderDetail1.setProductPrice(new BigDecimal(3.20));
        orderDetail1.setProductQuantity(2);
        orderDetailRepository.save(orderDetail1);
    }

}
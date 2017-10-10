package com.liujiaohan.sell.service.impI;

import com.liujiaohan.sell.dataobject.OrderDetail;
import com.liujiaohan.sell.dto.OrderDTO;
import com.liujiaohan.sell.enums.OrderStatusEnum;
import com.liujiaohan.sell.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;



@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    private static String buyerOpenId="123456";

    private static String ORDERID="1504354751112903749";

    @Test
    public void create() throws Exception {
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName("刘佼涵");
        orderDTO.setBuyerAddress("湖北武汉");
        orderDTO.setBuyerOpenid(buyerOpenId);
        orderDTO.setBuyerPhone("13163279968");

        List<OrderDetail> list=new ArrayList<>();
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setProductId("123");
        orderDetail.setProductQuantity(2);
        list.add(orderDetail);

        orderDTO.setList(list);

        OrderDTO result=orderService.create(orderDTO);


    }

    @Test
    public void findOne() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDERID);
        Assert.assertEquals(ORDERID,orderDTO.getOrderId());
    }

    @Test
    public void findList() throws Exception {
        PageRequest request=new PageRequest(0,2);
        Page<OrderDTO> orderDTOPage=orderService.findList(request);
        Assert.assertNotEquals(0,orderDTOPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDERID);
        orderDTO=orderService.cancel(orderDTO);
        Assert.assertEquals(OrderStatusEnum.Cancel.getCode(),orderDTO.getOrderStatus());
    }

    @Test
    public void paid() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDERID);
        orderDTO=orderService.paid(orderDTO);
        Assert.assertEquals(PayStatusEnum.PAIED.getCode(),orderDTO.getPayStatus());
    }

    @Test
    public void complete() throws Exception {
        OrderDTO orderDTO=orderService.findOne(ORDERID);
        orderDTO=orderService.complete(orderDTO);
        Assert.assertEquals(OrderStatusEnum.Completed.getCode(),orderDTO.getOrderStatus());
    }

}
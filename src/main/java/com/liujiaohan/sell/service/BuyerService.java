package com.liujiaohan.sell.service;

import com.liujiaohan.sell.dto.OrderDTO;

public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String orderid,String openid);

    //取消订单
    OrderDTO cancelOrder(String orderid,String openid);
}

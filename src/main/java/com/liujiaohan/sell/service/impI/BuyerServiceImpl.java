package com.liujiaohan.sell.service.impI;

import com.liujiaohan.sell.dto.OrderDTO;
import com.liujiaohan.sell.enums.ResultEnum;
import com.liujiaohan.sell.exception.SellException;
import com.liujiaohan.sell.service.BuyerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl implements BuyerService{
    @Autowired
    private OrderServiceImpl orderService;

    @Override
    public OrderDTO findOrderOne(String orderid, String openid) {
        return checkOrderOwner(openid,orderid);
    }

    @Override
    public OrderDTO cancelOrder(String orderid, String openid) {
        OrderDTO orderDTO=checkOrderOwner(openid,orderid);
        if (orderDTO==null){
            log.error("[取消订单] 查不到订单 orderId={}",orderid);
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDTO);
    }

    private OrderDTO checkOrderOwner(String opendid,String orderId){
        OrderDTO orderDTO=orderService.findOne(orderId);
        if (!orderDTO.getBuyerOpenid().equalsIgnoreCase(opendid)){
            log.error("[查询订单] 订单openid不一致 openid={},orderDTO={}",opendid,orderDTO);
            throw new SellException(ResultEnum.ORDER_OWNER_ERROR);
        }
        return orderDTO;
    }
}

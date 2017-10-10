package com.liujiaohan.sell.controller;

import com.liujiaohan.sell.dataobject.OrderMaster;
import com.liujiaohan.sell.dto.OrderDTO;
import com.liujiaohan.sell.enums.ResultEnum;
import com.liujiaohan.sell.exception.SellException;
import com.liujiaohan.sell.service.impI.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pay")
@Slf4j
public class PayController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/create")
    public void create(@RequestParam("orderId") String orderId,
                       @RequestParam("returnUrl") String returnUrl){
        //1.查询订单
        OrderDTO orderDTO=orderService.findOne(orderId);
        if (orderDTO==null){
            log.error("[支付]订单不存在");
            throw new SellException(ResultEnum.ORDER_NOT_EXIST);
        }
        //2.
    }
}

package com.liujiaohan.sell.service.impI;

import com.liujiaohan.sell.dto.OrderDTO;
import com.liujiaohan.sell.service.PayService;
import com.lly835.bestpay.service.impl.BestPayServiceImpl;

public class PayServiceImpl implements PayService{
    @Override
    public void create(OrderDTO orderDTO) {
        BestPayServiceImpl bestPayService=new BestPayServiceImpl();
    }
}

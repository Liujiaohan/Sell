package com.liujiaohan.sell.Converter;

import com.liujiaohan.sell.dataobject.OrderMaster;
import com.liujiaohan.sell.dto.OrderDTO;
import org.springframework.beans.BeanUtils;

public class OrderDTOToOrderMasterConverter {
    public static OrderMaster convert(OrderDTO orderDTO){
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDTO,orderMaster);
        return orderMaster;
    }
}

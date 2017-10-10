package com.liujiaohan.sell.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.liujiaohan.sell.dataobject.OrderDetail;
import com.liujiaohan.sell.dto.OrderDTO;
import com.liujiaohan.sell.enums.ResultEnum;
import com.liujiaohan.sell.exception.SellException;
import com.liujiaohan.sell.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderFormToOrderDTOConverter {
    public static OrderDTO convert(OrderForm orderForm){
        OrderDTO orderDTO=new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        Gson gson=new Gson();
        List<OrderDetail> list=new ArrayList<>();
        try{
            list=gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("[对象转换错误]，string={}",orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setList(list);
        return orderDTO;
    }
}

package com.liujiaohan.sell.service;

import com.liujiaohan.sell.dto.OrderDTO;

public interface PayService {
    void create(OrderDTO orderDTO);
}

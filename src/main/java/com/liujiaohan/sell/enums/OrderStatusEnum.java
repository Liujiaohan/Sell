package com.liujiaohan.sell.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NewOrder(0,"新下单"),
    Completed(1,"完结"),
    Cancel(2,"取消");


    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

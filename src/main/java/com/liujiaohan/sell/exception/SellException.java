package com.liujiaohan.sell.exception;

import com.liujiaohan.sell.enums.ResultEnum;

public class SellException extends RuntimeException{
    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        code=resultEnum.getCode();
    }
}

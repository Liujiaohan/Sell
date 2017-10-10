package com.liujiaohan.sell.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.liujiaohan.sell.dataobject.OrderDetail;
import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus;

    private Integer payStatus;

    private Date createTime;

    private Date updateTime;

    private List<OrderDetail> list=new ArrayList<>();
}

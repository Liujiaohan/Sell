package com.liujiaohan.sell.dataobject;

import com.liujiaohan.sell.enums.OrderStatusEnum;
import com.liujiaohan.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
public class OrderMaster {

    @Id
    private String orderId;

    private String buyerName;

    private String buyerPhone;

    private String buyerAddress;

    private String buyerOpenid;

    private BigDecimal orderAmount;

    private Integer orderStatus=OrderStatusEnum.NewOrder.getCode();

    private Integer payStatus=PayStatusEnum.WAIT.getCode();

    private Date createTime;

    private Date updateTime;
    public OrderMaster() {
    }
}

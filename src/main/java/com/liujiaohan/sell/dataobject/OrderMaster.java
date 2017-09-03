package com.liujiaohan.sell.dataobject;

import com.liujiaohan.sell.enums.OrderStatusEnum;
import com.liujiaohan.sell.enums.PayStatusEnum;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

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

    public OrderMaster() {
    }
}

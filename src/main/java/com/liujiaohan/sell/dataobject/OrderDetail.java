package com.liujiaohan.sell.dataobject;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
public class OrderDetail {

    @Id
    private String detailId;

    private String productId;

    private String orderId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productQuantity;

    private String productIcon;

    public OrderDetail() {
    }
}

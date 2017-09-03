package com.liujiaohan.sell.dataobject;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Data
public class ProductInfo {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPrice;
    private Integer productStock;
    private String productDescription;
    private String productIcon;
    private Integer categoryType;
    /* 0正常1下架*/
    private Integer productStatus;

    public ProductInfo() {
    }
}

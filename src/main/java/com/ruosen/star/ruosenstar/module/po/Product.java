package com.ruosen.star.ruosenstar.module.po;


import com.ruosen.star.ruosenstar.module.base.BasePo;
import lombok.Data;

import java.io.Serializable;

@Data
public class Product extends BasePo implements Serializable {

    private static final long serialVersionUID = 7519342508538810997L;

    private String productName;

    private String productCode;

    private String describe;

    private double productPrice;

    private String productDetail;

    private Integer status;


}

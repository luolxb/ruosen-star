package com.ruosen.star.ruosenstar.module.vo;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductVo implements Serializable {

    private static final long serialVersionUID = 7519342508538810997L;

    private Long id;

    private String productName;

    private String productCode;

    private String describe;

    private double productPrice;

    private Integer status;

    private String productDetail;

    private CategoryVo categoryVo;

    private CategoryVo parentCategoryVo;

    private List<AttachmentVo> attachmentVos;

}

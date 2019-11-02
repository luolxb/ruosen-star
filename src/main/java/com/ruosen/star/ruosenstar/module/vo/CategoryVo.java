package com.ruosen.star.ruosenstar.module.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVo implements Serializable {

    private static final long serialVersionUID = -6771024163088694758L;

    private Long id;

    private String categoryName;

    private String categoryCode;

    private String parentCode;


}

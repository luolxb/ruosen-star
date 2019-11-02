package com.ruosen.star.ruosenstar.module.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryRq implements Serializable {

    private static final long serialVersionUID = -6771024163088694758L;

    private Long id;

    @NotNull(message = "品类名称不能为空")
    private String categoryName;

    private String categoryCode;

    private String parentCode;


}

package com.ruosen.star.ruosenstar.module.po;


import com.ruosen.star.ruosenstar.module.base.BasePo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BasePo implements Serializable {

    private static final long serialVersionUID = -6771024163088694758L;

    private String categoryName;
    private String categoryCode;
    private String parentCode;


}

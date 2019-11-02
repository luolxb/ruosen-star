package com.ruosen.star.ruosenstar.module.po;

import com.ruosen.star.ruosenstar.module.base.BasePo;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryProduct extends BasePo implements Serializable {


    private static final long serialVersionUID = 8025888613001349482L;

    private long categoryId;

    private long productId;


}

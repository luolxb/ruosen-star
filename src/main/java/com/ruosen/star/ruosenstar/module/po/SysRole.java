package com.ruosen.star.ruosenstar.module.po;

import com.ruosen.star.ruosenstar.module.base.BasePo;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysRole extends BasePo implements Serializable {

    private static final long serialVersionUID = 6683528527429205548L;
    private String roleCode;

    private String roleName;



}

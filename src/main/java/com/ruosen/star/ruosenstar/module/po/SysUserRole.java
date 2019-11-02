package com.ruosen.star.ruosenstar.module.po;

import com.ruosen.star.ruosenstar.module.base.BasePo;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysUserRole extends BasePo implements Serializable {

    private static final long serialVersionUID = -1350367417527123698L;

    private long roleId;

    private long userId;

}

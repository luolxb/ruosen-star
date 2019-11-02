package com.ruosen.star.ruosenstar.module.po;

import com.ruosen.star.ruosenstar.module.base.BasePo;
import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleMenu extends BasePo implements Serializable {

    private static final long serialVersionUID = -7790905171337570013L;
    private long roleId;
    private long menuId;

}

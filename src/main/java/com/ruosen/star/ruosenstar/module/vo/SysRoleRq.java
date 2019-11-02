package com.ruosen.star.ruosenstar.module.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class SysRoleRq implements Serializable {

    private static final long serialVersionUID = 6683528527429205548L;

    private Long id;

    private String roleCode;

    private String roleName;


}

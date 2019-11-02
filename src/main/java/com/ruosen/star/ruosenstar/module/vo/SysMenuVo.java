package com.ruosen.star.ruosenstar.module.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     SysMenu   
 *  * @package    com.ruosen.star.ruosenstar.module.po  
 *  * @author Administrator     
 *  * @date   2019/9/30 0030 星期一
 *  * @version V1.0.0
 *  
 */
@Data
public class SysMenuVo implements Serializable {

    private static final long serialVersionUID = 796824085197446726L;

    private Long id;

    private String menuCode;

    private String menuName;

    private String url;

    private String levels;

    private String parentCode;

    private long sortNum;

    private String icon;

    private List<SysMenuVo> childMenus;
}

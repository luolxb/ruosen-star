package com.ruosen.star.ruosenstar.module.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 *  系统用户返回试图实体类
 *  * @projectName ruosen-star
 *  * @title     SysUserVo   
 *  * @package    com.ruosen.star.ruosenstar.module.po.vo  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@Data
public class SysUserVo implements Serializable {

    private static final long serialVersionUID = -1067510545312732139L;

    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名称")
    private String userName;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    private String sex;
}

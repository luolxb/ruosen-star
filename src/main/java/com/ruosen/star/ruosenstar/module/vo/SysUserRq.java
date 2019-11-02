package com.ruosen.star.ruosenstar.module.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *  系统用户请求实体类
 *  * @projectName ruosen-star
 *  * @title     SysUserVo   
 *  * @package    com.ruosen.star.ruosenstar.module.po.vo  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@Data
public class SysUserRq implements Serializable {

    private static final long serialVersionUID = -1771677495107190698L;

    private Long id;
    /**
     * 用户名
     */
    @NotNull(message = "用户名称不能为空")
    @ApiModelProperty(value = "用户名称")
    private String name;

    /**
     * 昵称
     */
    @NotNull(message = "用户昵称不能为空")
    @ApiModelProperty(value = "用户昵称")
    private String nickName;

    /**
     * 密码
     */
    @NotNull(message = "用户密码不能为空")
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 年龄
     */
    @NotNull(message = "用户年龄不能为空")
    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @NotNull(message = "用户性别不能为空")
    @ApiModelProperty(value = "用户性别")
    private String sex;


    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;
}

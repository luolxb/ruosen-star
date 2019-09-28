package com.ruosen.star.ruosenstar.module.po;

import com.ruosen.star.ruosenstar.module.base.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *  系统用户实体类
 *  * @projectName ruosen-star
 *  * @title     SysUser   
 *  * @package    com.ruosen.star.ruosenstar.module.po  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@ApiModel(description = "系统用户实体类")
public class SysUser extends BasePo {

    private static final long serialVersionUID = -30499497127813036L;

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

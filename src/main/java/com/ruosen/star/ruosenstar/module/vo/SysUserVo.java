package com.ruosen.star.ruosenstar.module.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruosen.star.ruosenstar.annotation.PushMqJsonElement;
import com.ruosen.star.ruosenstar.annotation.PushMqJsonSerializable;
import com.ruosen.star.ruosenstar.module.po.SysMenu;
import com.ruosen.star.ruosenstar.module.po.SysRole;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

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
@Accessors(chain = true)
@PushMqJsonSerializable
public class SysUserVo implements Serializable {

    private static final long serialVersionUID = -1067510545312732139L;

    private Long id;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名称")
    @PushMqJsonElement("userName")
    private String name;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "用户昵称")
    @PushMqJsonElement
    private String nickName;

    /**
     * 密码
     */
    @JsonIgnore
    @ApiModelProperty(value = "用户密码")
    private String password;

    /**
     * 年龄
     */
    @PushMqJsonElement("userAge")
    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @PushMqJsonElement
    @ApiModelProperty(value = "用户性别")
    private String sex;

    @TableField(exist = false)
    private List<SysRole> roleList;

    @TableField(exist = false)
    private List<SysMenu> menuList;
}

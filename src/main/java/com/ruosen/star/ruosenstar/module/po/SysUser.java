package com.ruosen.star.ruosenstar.module.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ruosen.star.ruosenstar.module.base.BasePo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Set;

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
public class SysUser extends BasePo implements UserDetails {

    private static final long serialVersionUID = -30499497127813036L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名称")
    private String name;

    /**
     * 昵称
     */
    @ApiModelProperty(value = "用户昵称")
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
    @ApiModelProperty(value = "用户年龄")
    private Integer age;

    @ApiModelProperty(value = "用户性别")
    private String sex;

    @TableField(exist = false)
    private List<SysRole> roleList;

    @TableField(exist = false)
    private List<SysMenu> menuList;


    @JsonIgnore
    @TableField(exist = false)
    private Set<String> permission;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

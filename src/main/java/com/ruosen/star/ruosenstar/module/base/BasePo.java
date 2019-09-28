package com.ruosen.star.ruosenstar.module.base;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 *  公共属性抽取 实体类
 *  * @projectName ruosen-star
 *  * @title     BasePo   
 *  * @package    com.ruosen.star.ruosenstar.module.po  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
@ToString
@ApiModel(description = "公共属性抽取 实体类")
public class BasePo implements Serializable {

    private static final long serialVersionUID = 7360157342935183044L;

    /**
     * ID
     */
    private Long id;

    /**
     * 备用字段1
     */
    private String remark1;

    /**
     * 备用字段2
     */
    private String remark2;

    /**
     * 备用字段3
     */
    private String remark3;

    /**
     * 备用字段4
     */
    private String remark4;

    /**
     * 备用字段5
     */
    private String remark5;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 修改时间
     */
    private Date updateDate;

    /**
     * 修改人
     */
    private String updateBy;

    /**
     * 是否启用  Y:启用 ; N:禁用
     */
    private String enable;

    /**
     * 是否删除状态  Y:删除  N:没有删除
     */
    private String isDelete;
}

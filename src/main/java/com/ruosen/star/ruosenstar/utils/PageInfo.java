package com.ruosen.star.ruosenstar.utils;

import lombok.Data;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     pageInfo   
 *  * @package    com.ruosen.star.ruosenstar.module.po  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@Data
public class PageInfo {

    private Integer size = 10;

    private Integer current = 1;
}

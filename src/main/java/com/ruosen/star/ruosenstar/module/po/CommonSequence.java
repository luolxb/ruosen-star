package com.ruosen.star.ruosenstar.module.po;

import lombok.Data;

/**
 *  公共序列类
 *  * @projectName ruosen-star
 *  * @title     CommonSequence   
 *  * @package    com.ruosen.star.ruosenstar.module.po  
 *  * @author Administrator     
 *  * @date   2019/10/6 0006 星期日
 *  * @version V1.0.0
 *  
 */
@Data
public class CommonSequence {

    private Long id;

    private String code;

    public CommonSequence(String code) {
        this.code = code;
    }
}

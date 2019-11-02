package com.ruosen.star.ruosenstar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruosen.star.ruosenstar.module.po.CommonSequence;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     CommonSequenceService   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/10/6 0006 星期日
 *  * @version V1.0.0
 *  
 */
public interface CommonSequenceService extends IService<CommonSequence> {

    /**
     * 生成序列
     *
     * @param prefix
     * @param pattern
     * @param count
     * @return
     */
    String generate(String prefix, String pattern, int count);
}

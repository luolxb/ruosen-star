package com.ruosen.star.ruosenstar.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruosen.star.ruosenstar.module.po.CommonSequence;
import org.apache.ibatis.annotations.Param;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     CommonSequenceMapper.xml   
 *  * @package    com.ruosen.star.ruosenstar.dao  
 *  * @author Administrator     
 *  * @date   2019/10/6 0006 星期日
 *  * @version V1.0.0
 *  
 */
public interface CommonSequenceMapper extends BaseMapper<CommonSequence> {

    /**
     * 获取序列值，
     *
     * @param count 制定序列长度
     * @return 序列长度不够钱补齐0
     */
    String querySequence(@Param("count") int count);
}

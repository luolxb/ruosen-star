package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.CommonSequenceMapper;
import com.ruosen.star.ruosenstar.module.po.CommonSequence;
import com.ruosen.star.ruosenstar.service.CommonSequenceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     CommonSequenceServiceimpl   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/10/6 0006 星期日
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class CommonSequenceServiceimpl extends ServiceImpl<CommonSequenceMapper, CommonSequence>
        implements CommonSequenceService {
    /**
     * 生成序列
     *
     * @param prefix
     * @param pattern
     * @param count
     * @return
     */
    @Override
    public String generate(String prefix, String pattern, int count) {
        String generate = prefix + DateFormatUtils.format(new Date(), pattern) + this.baseMapper.querySequence(count);
        this.baseMapper.insert(new CommonSequence(generate));
        return generate;
    }
}

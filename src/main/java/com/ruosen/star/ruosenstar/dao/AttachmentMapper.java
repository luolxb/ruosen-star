package com.ruosen.star.ruosenstar.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ruosen.star.ruosenstar.module.po.Attachment;
import com.ruosen.star.ruosenstar.module.po.AttachmentAssociated;
import com.ruosen.star.ruosenstar.module.vo.AttachmentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     AttachmentMapper   
 *  * @package    com.ruosen.star.ruosenstar.dao  
 *  * @author Administrator     
 *  * @date   2019/10/7 0007 星期一
 *  * @version V1.0.0
 *  
 */
public interface AttachmentMapper extends BaseMapper<Attachment> {

    /**
     * 获取附件信息
     *
     * @param attachmentAssociated
     * @return
     */
    List<AttachmentVo> getAttachmentVoList(@Param("attachmentAssociated") AttachmentAssociated attachmentAssociated);
}

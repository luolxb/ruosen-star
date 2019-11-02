package com.ruosen.star.ruosenstar.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruosen.star.ruosenstar.dao.AttachmentMapper;
import com.ruosen.star.ruosenstar.module.po.Attachment;
import com.ruosen.star.ruosenstar.module.po.AttachmentAssociated;
import com.ruosen.star.ruosenstar.module.vo.AttachmentVo;
import com.ruosen.star.ruosenstar.service.AttachmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     AttachmentServiceImpl   
 *  * @package    com.ruosen.star.ruosenstar.service.impl  
 *  * @author Administrator     
 *  * @date   2019/10/7 0007 星期一
 *  * @version V1.0.0
 *  
 */
@Slf4j
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment>
        implements AttachmentService {


    /**
     * 获取附件信息
     *
     * @return
     */
    @Override
    public List<AttachmentVo> getAttachmentVoList(AttachmentAssociated attachmentAssociated) {
        return this.baseMapper.getAttachmentVoList(attachmentAssociated);
    }
}

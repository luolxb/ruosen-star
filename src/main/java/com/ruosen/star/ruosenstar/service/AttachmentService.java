package com.ruosen.star.ruosenstar.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruosen.star.ruosenstar.module.po.Attachment;
import com.ruosen.star.ruosenstar.module.po.AttachmentAssociated;
import com.ruosen.star.ruosenstar.module.vo.AttachmentVo;

import java.util.List;

/**
 *  
 *  * @projectName ruosen-star
 *  * @title     AttachmentService   
 *  * @package    com.ruosen.star.ruosenstar.service  
 *  * @author Administrator     
 *  * @date   2019/10/7 0007 星期一
 *  * @version V1.0.0
 *  
 */
public interface AttachmentService extends IService<Attachment> {

    /**
     * 获取附件信息
     *
     * @return
     */
    List<AttachmentVo> getAttachmentVoList(AttachmentAssociated attachmentAssociated);
}

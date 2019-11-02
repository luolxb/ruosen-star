package com.ruosen.star.ruosenstar.module.po;

import com.ruosen.star.ruosenstar.module.base.BasePo;
import lombok.Data;

import java.io.Serializable;

@Data
public class AttachmentAssociated extends BasePo implements Serializable {

    private long moduleId;

    private long attachmentId;

    private long moduleType;

    private long attachmentType;


}

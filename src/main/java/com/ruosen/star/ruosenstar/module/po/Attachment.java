package com.ruosen.star.ruosenstar.module.po;


import com.ruosen.star.ruosenstar.module.base.BasePo;
import lombok.Data;

import java.io.Serializable;

@Data
public class Attachment extends BasePo implements Serializable {

    private static final long serialVersionUID = -1594361093961967685L;

    private String attachmentKey;

    private long attachmentSize;

    private String attachmentUrl;


}

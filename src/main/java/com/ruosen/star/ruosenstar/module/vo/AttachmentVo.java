package com.ruosen.star.ruosenstar.module.vo;


import lombok.Data;

import java.io.Serializable;

@Data
public class AttachmentVo implements Serializable {

    private static final long serialVersionUID = -1594361093961967685L;

    private Long id;

    private String attachmentKey;

    private long attachmentSize;

    private String attachmentUrl;


}

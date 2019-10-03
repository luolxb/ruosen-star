package com.ruosen.star.ruosenstar.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.AuthenticationException;

import java.util.Map;

/**
 *  认证异常
 *  * @projectName ruosen-star
 *  * @title     ValidatorException   
 *  * @package    com.ruosen.star.ruosenstar.exception  
 *  * @author Administrator     
 *  * @date   2019/9/30 0030 星期一
 *  * @version V1.0.0
 *  
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ValidatorException extends AuthenticationException {

    private static final long serialVersionUID = -584065881856242606L;

    private String code;

    private String msg;

    private Map data;

    public ValidatorException(String msg, Map data) {
        super(msg);
        this.msg = msg;
        this.data = data;
    }
}

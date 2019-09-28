package com.ruosen.star.ruosenstar.exception;

import com.ruosen.star.ruosenstar.module.Enums.ResultInfoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *  自定义异常处理类
 *  * @projectName ruosen-star
 *  * @title     MyException   
 *  * @package    com.ruosen.star.ruosenstar.exception  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@Data
@AllArgsConstructor
public class CustomException extends RuntimeException {

    private Integer errorCode;

    private String errorMessage;


    public CustomException(ResultInfoEnum resultInfoEnum) {
        new CustomException(resultInfoEnum.getCode(), resultInfoEnum.getMsg());
    }
}

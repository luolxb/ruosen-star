package com.ruosen.star.ruosenstar.exception;

import com.ruosen.star.ruosenstar.module.base.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *   捕获全局异常
 *  * @projectName ruosen-star
 *  * @title     GlobalException   
 *  * @package    com.ruosen.star.ruosenstar.exception  
 *  * @author Administrator     
 *  * @date   2019/9/28 0028 星期六
 *  * @version V1.0.0
 *  
 */
@Slf4j
@ControllerAdvice
public class GlobalException {


    /**
     * 全局异常捕捉处理
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseData errorHandler(Exception ex) {
        log.error(ex.getMessage());
        return new ResponseData().error("未知错误" + "[" + getExceptionTime() + "]");
    }

    /**
     * 拦截捕捉自定义异常 CustomException.class
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CustomException.class)
    public ResponseData customException(CustomException ex) {

        log.error(ex.getErrorMessage());
        ResponseData data = new ResponseData();
        data.setCode(ex.getErrorCode());
        data.setMsg(ex.getErrorMessage() + "[" + getExceptionTime() + "]");
        return data;
    }

    private String getExceptionTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }
}

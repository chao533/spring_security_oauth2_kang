package com.kang.common.exception;

import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kang.common.msg.ErrorCode;
import com.kang.common.msg.Message;

/**
 * <p>Title: DefaultExceptionHandler</p>  
 * <p>Description: 统一异常处理类</p>  
 * @author chaokang  
 * @date 2018年12月3日
 */
@RestControllerAdvice
public class DefaultExceptionHandler {

    @ExceptionHandler(InternalAuthenticationServiceException.class)
    public Message<String> processInternalAuthenticationServiceException(InternalAuthenticationServiceException e) {
        return new Message<String>(ErrorCode.ERROR_LOGIN.getCode(),e.getMessage());
    }
    
    @ExceptionHandler(ServiceException.class)
    public Message<String> processServiceException(ServiceException e) {
        return new Message<String>(ErrorCode.ERROR,e.getMessage());
    }
    
    
    

}

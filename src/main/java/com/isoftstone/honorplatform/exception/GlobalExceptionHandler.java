package com.isoftstone.honorplatform.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 全局异常处理器
 * 
 * @author ruoyi
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity mainException(Exception e) {
        ResponseEntity responseEntity = new ResponseEntity(e.getMessage(), null , HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }
}

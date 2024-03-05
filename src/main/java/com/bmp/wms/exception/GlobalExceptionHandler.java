package com.bmp.wms.exception;

import com.bmp.wms.api.BaseResponseFail;
import com.bmp.wms.api.ResultCode;
import com.bmp.wms.util.Const;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.MyBatisSystemException;
import org.slf4j.MDC;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * 전역 에러 처리 클래스입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@RestControllerAdvice
@Slf4j
@RequiredArgsConstructor
public class GlobalExceptionHandler {
    
    /**
     * ApiException 발생 시 처리합니다.
     *
     * @param e 발생한 ApiException
     * @return 에러 응답 객체 (BaseResponseFail)
     */
    @ExceptionHandler(value = ApiException.class)
    public BaseResponseFail handleApiException(ApiException e) {
        LocalDateTime nowTime = LocalDateTime.now();

        log.info("ApiExceptionHandler : {}, {}, {}, {}", nowTime, e.getCode(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);

        return BaseResponseFail.<Map<String, String>>builder()
                .transactionId(MDC.get(Const.LOG_KEY))
                .returnCode(ResultCode.WMS_FAIL.getCode())
                .returnDescription(ResultCode.WMS_FAIL.getMessage())
                .errorCode(e.getCode())
                .errorDescription(e.getMessage())
                .build();
    }

    /**
     * MethodArgumentNotValidException 발생 시 처리합니다.
     *
     * @param ex 발생한 MethodArgumentNotValidException
     * @return 에러 응답 객체 (BaseResponseFail)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponseFail<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return BaseResponseFail.<Map<String, String>>builder()
                .transactionId(MDC.get(Const.LOG_KEY))
                .returnCode(ResultCode.WMS_FAIL.getCode())
                .returnDescription(ResultCode.WMS_FAIL.getMessage())
                .errorCode(ResultCode.WMS_REQUIRED_PARAMS.getCode())
                .errorDescription(ResultCode.WMS_REQUIRED_PARAMS.getMessage())
                .response(errors)
                .build();
    }
    /**
     * DataAccessException 발생 시 처리합니다.
     *
     * @param se 발생한 DataAccessException
     * @return 에러 응답 객체 (BaseResponseFail)
     */
    @ExceptionHandler(MyBatisSystemException.class)
    public BaseResponseFail<Map<String, String>> handleMyBatisSystemException(MyBatisSystemException se) {
        Map<String, String> errors = new HashMap<>();
        log.info("errors : {}", se);
        errors.put("errorMessage", ResultCode.WMS_SQL_EXCEPTION.getMessage());

        return BaseResponseFail.<Map<String, String>>builder()
                .transactionId(MDC.get(Const.LOG_KEY))
                .returnCode(ResultCode.WMS_FAIL.getCode())
                .returnDescription(ResultCode.WMS_FAIL.getMessage())
                .errorCode(ResultCode.WMS_SQL_EXCEPTION.getCode())
                .errorDescription(ResultCode.WMS_SQL_EXCEPTION.getMessage())
                .response(errors)
                .build();
    }

    /**
     * DataAccessException 발생 시 처리합니다.
     *
     * @param se 발생한 DataAccessException
     * @return 에러 응답 객체 (BaseResponseFail)
     */
    @ExceptionHandler(DataAccessException.class)
    public BaseResponseFail<Map<String, String>> handleDataAccessException(DataAccessException se) {
        Map<String, String> errors = new HashMap<>();
        log.info("errors : {}", se.getMessage());
        errors.put("errorMessage", ResultCode.WMS_SQL_EXCEPTION.getMessage());

        return BaseResponseFail.<Map<String, String>>builder()
                .transactionId(MDC.get(Const.LOG_KEY))
                .returnCode(ResultCode.WMS_FAIL.getCode())
                .returnDescription(ResultCode.WMS_FAIL.getMessage())
                .errorCode(ResultCode.WMS_SQL_EXCEPTION.getCode())
                .errorDescription(ResultCode.WMS_SQL_EXCEPTION.getMessage())
                .response(errors)
                .build();
    }
}

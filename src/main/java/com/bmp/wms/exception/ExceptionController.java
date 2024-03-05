package com.bmp.wms.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;
import java.util.Map;
import java.util.Objects;

/**
 * 404 Not Found 에러를 처리하는 컨트롤러입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Controller
@Slf4j
public class ExceptionController implements ErrorController {

    /**
     * 404 Not Found 에러 발생 시 처리합니다.
     *
     * @param response HTTP 응답 객체
     * @param request HTTP 요청 객체
     * @return 404 응답 객체 (JSON 또는 문자열)
     */
    @RequestMapping(value = "/error")
    public ResponseEntity<Object> handleNoHandlerFoundException(HttpServletResponse response, HttpServletRequest request) {
        int status = response.getStatus();  // 에러 상태 코드 가져오기

        // 에러 디버깅 정보 출력 (로그 사용 권장)
        log.info("status : {}", status);  // 오류 상태 코드
        log.info("request.getRequestURI() : {}", request.getRequestURI());  // 요청 주소

        // 요청 컨텐츠 타입에 따른 응답 생성
        if (Objects.equals(request.getContentType(), MediaType.APPLICATION_JSON_VALUE)) {
            Map<String, Object> body = Collections.singletonMap("error", "Not Found");
            return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}

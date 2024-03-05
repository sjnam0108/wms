package com.bmp.wms.aspect;

import com.bmp.wms.api.BaseResponse;
import com.bmp.wms.domain.ApiHistory;
import com.bmp.wms.service.ApiHistoryService;
import com.bmp.wms.exception.ApiException;
import com.bmp.wms.util.CommUtil;
import com.bmp.wms.util.Const;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.Timestamp;
import java.util.Arrays;

/**
 * author   : jsper
 * fileName : ApiLogAspect
 * since    : 2024-03-01
 */
@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class ApiLogAspect {

    private final ApiHistoryService apiHistoryService;

    private long startTime;
    private long endTime;

    // 컨트롤러의 메소드 호출을 포인트컷으로 지정
    @Pointcut("execution(* com.bmp.wms.controller.*.*(..))")
    public void controllerMethods() {
    }

    @Before("controllerMethods()")
    public void logBefore(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis(); // 요청 종료 시간
    }

    @Around("controllerMethods()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result = null;
        Throwable thrownException = null; // 예외를 저장할 변수

        HttpServletRequest request = null;
        String clientIp = null;
        String apiId = null;
        String transactionId = null;
        String url = null;
        String method = null;
        Object[] args = null;
        String returnCode = null;

        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            if (e instanceof ApiException) {
                ApiException apiException = (ApiException) e;
                log.info("API 프로세스 실패: {}", apiException.getCode());
                log.info("API 프로세스 실패: {}", apiException.getMessage());
                result = apiException.getMessage();
                returnCode = apiException.getCode();
                throw e;
            } else {
                log.error("API 프로세스 실패", e);
                throw e;
            }
        } finally {
            endTime = System.currentTimeMillis();

            request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            clientIp = CommUtil.getClientIp(request);
            apiId = joinPoint.getSignature().toShortString();
            transactionId = CommUtil.generateTransactionId();
            url = getRequestMappingUrl(joinPoint);
            method = joinPoint.getSignature().getName();
            args = joinPoint.getArgs();

            // 정상적인 경우
            if (result instanceof BaseResponse) {
                BaseResponse<?> baseResponse = (BaseResponse<?>) result;
                returnCode = baseResponse.getReturnCode();
            }

            log.info("API 호출 시작 시간: {}", new Timestamp(startTime));
            log.info("Request URL: {}", url);
            log.info("Method: {}", method);
            log.info("Request Arguments: {}", Arrays.toString(args));
            log.info("clientIp: {}", clientIp);
            log.info("Response: {}", result);
            log.info("returnCode: {}", returnCode);
            log.info("API 호출 종료 시간: {}", new Timestamp(endTime));
            log.info("API 처리 시간: {} ms", endTime - startTime);

            ApiHistory history = ApiHistory.builder()
                .transactionId(transactionId)
                .apiNm(url)
                .requestSystem(Const.API_SERVER)
                .requestDtm(new Timestamp(startTime))
                .outsideApiNm(null)
                .outsideApiCallDtm(null)
                .createDtm(new Timestamp(endTime))
                .responseResult(null)
                .resultCode(returnCode)
                .requestDesc(Arrays.toString(args))
                .responseDesc(result.toString())
                .rgstUserIp(clientIp)
                .build();

            apiHistoryService.createApiHistory(history);
        }

        return result;
    }

    // 컨트롤러 메소드에 붙은 RequestMapping 어노테이션에서 URL 추출
    private String getRequestMappingUrl(JoinPoint joinPoint) {
        Class<?> targetClass = joinPoint.getTarget().getClass();
        RequestMapping requestMapping = targetClass.getAnnotation(RequestMapping.class);
        String classMapping = (requestMapping != null && requestMapping.value().length > 0) ? requestMapping.value()[0] : "";
        String methodMapping = "";
        try {
            RestController restController = targetClass.getAnnotation(RestController.class);
            if (restController != null) {
                String methodName = joinPoint.getSignature().getName();
                for (var method : targetClass.getDeclaredMethods()) {
                    if (method.getName().equals(methodName)) {
                        if (method.isAnnotationPresent(RequestMapping.class)) {
                            RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
                            methodMapping = methodRequestMapping.value()[0];
                        } else if (method.isAnnotationPresent(GetMapping.class)) {
                            GetMapping getMapping = method.getAnnotation(GetMapping.class);
                            methodMapping = getMapping.value()[0];
                        } else if (method.isAnnotationPresent(PostMapping.class)) {
                            PostMapping postMapping = method.getAnnotation(PostMapping.class);
                            methodMapping = postMapping.value()[0];
                        } else if (method.isAnnotationPresent(PutMapping.class)) {
                            PutMapping putMapping = method.getAnnotation(PutMapping.class);
                            methodMapping = putMapping.value()[0];
                        }
                        break;
                    }
                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }

        return classMapping + methodMapping;
    }

}

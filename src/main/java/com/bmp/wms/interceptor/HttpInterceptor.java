package com.bmp.wms.interceptor;

import com.bmp.wms.util.Const;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

/**
 * HTTP 요청을 가로채어 로그 및 트랜잭션 ID를 관리하는 인터셉터입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Slf4j
@Component
public class HttpInterceptor implements HandlerInterceptor {

  /**
   * 컨트롤러 실행 전, 요청 정보를 로그에 남기고 트랜잭션 ID를 생성합니다.
   *
   * @param request HTTP 요청 객체
   * @param response HTTP 응답 객체
   * @param handler 요청을 처리할 핸들러
   * @return 컨트롤러 실행을 진행할지 여부 (true: 진행, false: 중단)
   */
  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    String logkey = UUID.randomUUID().toString();  // 트랜잭션 ID 생성
    MDC.put(Const.LOG_KEY, logkey);
    log.info("========== [START] ==========");
    return true;
  }

  /**
   * 뷰 실행 후, 로그 마킹을 종료하고 MDC에서 트랜잭션 ID를 제거합니다.
   */
  @Override
  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
      throws Exception {
    log.info("========== [END] ==========");
    MDC.remove(Const.LOG_KEY);
  }
}

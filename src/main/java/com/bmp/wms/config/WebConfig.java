package com.bmp.wms.config;

import com.bmp.wms.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 웹 설정을 위한 클래스입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

  /**
   * 인터셉터 설정을 추가합니다.
   *
   * @param registry 인터셉터 등록 객체
   */
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry
        // HttpInterceptor를 모든 URL에 적용합니다.
        .addInterceptor(new HttpInterceptor())
        .addPathPatterns("/**")
        // 정적 자원 URL은 제외합니다.
        .excludePathPatterns("/assets/**", "/css/**", "/error", "/favicon.ico");
  }

  /**
   * CORS 설정을 추가합니다.
   *
   * @param registry CORS 설정 등록 객체
   */
  @Override
  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
        // 모든 Origin 허용
        .allowedOriginPatterns("*")
        // 모든 메서드 허용
        .allowedMethods("*")
        // 모든 헤더 허용
        .allowedHeaders("*")
        // 쿠키 허용
        .allowCredentials(true);
  }
}

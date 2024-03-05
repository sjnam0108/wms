package com.bmp.wms.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * SpringDoc OpenAPI를 사용하여 API 문서를 자동 생성하기 위한 설정 클래스입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Configuration
public class OpenApiConfig {

    /**
     * OpenAPI 문서를 생성하고 설정합니다.
     *
     * @return OpenAPI 객체
     */
    @Bean
    public OpenAPI openAPI() {
        Info info = new Info()
            .title("CNMS API Document")
            .version("v0.0.1")
            .description("CNMS API 명세서입니다.");
        return new OpenAPI()
            .components(new Components())
            .info(info);
    }
}

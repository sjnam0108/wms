package com.bmp.wms.api;

import lombok.Builder;
import lombok.Data;

/**
 * API 실패 응답 기본 모델입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 * param <T> 응답 데이터 타입
 */
@Data
@Builder
public class BaseResponseFail<T> {

  /**
   * 트랜잭션 ID입니다.
   */
  private String transactionId;

  /**
   * 응답 코드입니다.
   */
  private String returnCode;

  /**
   * 응답 설명입니다.
   */
  private String returnDescription;

  /**
   * 에러 코드입니다.
   */
  private String errorCode;

  /**
   * 에러 설명입니다.
   */
  private String errorDescription;

  /**
   * 응답 데이터입니다.
   */
  private T response;
}

package com.bmp.wms.api;

import lombok.Builder;
import lombok.Data;

/**
 * 전화번호 형식 검증을 위한 커스텀 어노테이션입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 * param <T> 응답 데이터 타입
 */
@Data
@Builder
public class BaseResponse<T> {

  /**
   * 트랜잭션 ID입니다.
   */
  private String transactionId;

  /**
   * 시퀀스 번호입니다.
   */
  private String sequenceNo;

  /**
   * 응답 코드입니다.
   */
  private String returnCode;

  /**
   * 응답 설명입니다.
   */
  private String returnDescription;

  /**
   * 응답 데이터입니다.
   */
  private T response;
}

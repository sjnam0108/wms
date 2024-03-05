package com.bmp.wms.model.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 사용자 목록 응답 DTO입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Data
@Builder
public class UserListResponse {
  /**
   * 전체 사용자 수입니다.
   */
  private int totalCnt;

  /**
   * 페이지당 표시할 사용자 수입니다.
   */
  private int limit;

  /**
   * 페이지 시작 위치입니다.
   */
  private int offset;

  /**
   * 사용자 정보 목록입니다.
   */
  private List<UserResponse> users;
}

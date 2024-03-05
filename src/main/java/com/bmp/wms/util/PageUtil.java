package com.bmp.wms.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 페이지 유틸 클래스입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Getter
@AllArgsConstructor
public class PageUtil {
  /**
   * 페이지당 표시할 항목 수입니다.
   */
  private int limit;

  /**
   * 페이지 시작 위치입니다.
   */
  private int offset;

  /**
   * 검색 대상 컬럼명입니다.
   */
  private String searchColumn;

  /**
   * 검색어입니다.
   */
  private String searchString;

}

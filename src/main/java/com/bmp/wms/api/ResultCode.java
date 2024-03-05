package com.bmp.wms.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 결과 코드가 정의 되어 있는 Enum Class
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 * param <T> 응답 데이터 타입
 */
@Getter
@AllArgsConstructor
public enum ResultCode {

  WMS_SUCCESS("1", "Success"),
  WMS_FAIL("0", "Fail"),

  WMS_TOKEN_INVALID("WMS20001", "TOKEN_INVALID"),
  WMS_EXPIRED_TOKEN("WMS20002", "EXPIRED_TOKEN"),
  WMS_UNSUPPORTED_TOKEN("WMS20003", "UNSUPPORTED_TOKEN"),
  WMS_ILLEGAL_ARGUMENT("WMS20004", "ILLEGAL_ARGUMENT"),

  WMS_UNKNOWN_EXCEPTION("WMS20005", "예상치 못한 오류" ),
  WMS_REQUIRED_PARAMS("WMS20006", "파라미터 오류"),
  WMS_ACCESS_DENIED("WMS20007", "접근권한 없음"),

  WMS_USER_PROFILE_VALUE_ERROR("WMS20008", "프로필값 오류"),
  WMS_USER_NOT_FOUND("WMS20009", "회원정보 없음"),
  WMS_USER_EXIST("WMS20010", "회원정보 있음"),
  WMS_USER_PWD_DISCREPANCY("WMS20011", "비밀번호불일치"),
  WMS_USER_NOT_AUTH("WMS20012", "인증실패"),
  WMS_USER_NOT_MATCH("WMS20013", "토큰과 수정정보 불일치"),
  WMS_SQL_EXCEPTION("WMS20014", "SQL 처리 오류"),
  
  // 앱 코드 정보
  WMS_APP_NOT_FOUND("WMS20200", "앱 정보 없음"),
  WMS_WELCOME_NOT_FOUND("WMS20201", "웰컴 메시지 정보 없음"),
  WMS_NOTICE_NOT_FOUND("WMS20202", "공지사항 정보 없음"),
  WMS_FILE_DIR_EXCEPTION("WMS20203", "파일 폴더 생성 오류"),
  WMS_FILE_SAVE_EXCEPTION("WMS20203", "파일 저장 오류"),
  WMS_FILE_TYPE_EXCEPTION("WMS20204", "파일 타입 오류"),

  WMS_WEATHER_EXCEPTION("WMS20205", "날씨 연동 오류"),

  WMS_NTFC_NOT_FOUND("WMS20206", "알림정보 없음"),

  WMS_AES_ENC_NOT("WMS20900", "AES 암호화 오류"),
  WMS_AES_DEC_NOT("WMS20901", "AES 복호화 오류")



  ;
  private String code;
  private String message;
}
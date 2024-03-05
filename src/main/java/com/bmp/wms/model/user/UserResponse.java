package com.bmp.wms.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
/**
 * 사용자 응답 요청 DTO입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Data
@AllArgsConstructor
@Builder
public class UserResponse {

  // 사용자 번호
  private BigDecimal usrNo;
  // 사용자 아이디
  private String usrId;
  // 테넌트 아이디
  private String tnntId;
  // 이름
  private String nm;
  // 휴대전화 번호
  private String mblTelNo;
  // 전화번호
  private String telNo;
  // 사용자 유형
  private String usrType;
  // 계정 사용 시작 일자
  private Timestamp acntUseBgngDay;
  // 계정 사용 종료 일자
  private Timestamp acntUseEndDay;
  // JBGD 코드
  private String jbgdNo;
  // JBTTL 코드
  private String jbttlCd;
  // 우편번호
  private String zip;
  // 기본 주소
  private String bscAddr;
  // 상세 주소
  private String dtlAddr;
  // 상태
  private String stts;
  // 이메일
  private String eml;
  // 승인 여부
  private String confirm;
  // 파일 경로
  private String prflFileUrl;
  // 파일 원본명
  private String prflOrgFileNm;
  // 파일 저장명
  private String prflSaveFileNm;
  // 최종 연락 일시
  private Timestamp lastCntnDt;
  // 등록자 아이디
  private String rgstUserId;
  // 등록자 IP 주소
  private String rgstUserIp;
  // 등록 일시
  private Timestamp rgstDtm;
  // 수정자 아이디
  private String updUserId;
  // 수정자 IP 주소
  private String updUserIp;
  // 수정 일시
  private Timestamp updDtm;

}
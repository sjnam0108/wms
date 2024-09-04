package com.bmp.wms.model.meeting;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

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
public class MeetingResponse {

  private BigDecimal mtgRsvtUnqNo;

  // 회의예약 번호
  private BigDecimal wlcmMsgUnqNo;

   // 사용자 번호
  private BigDecimal usrNo;

   // 회의 주최자
  private String mtgSprvsn;

  //회의 제목
  private String mtgTtl;

  //회의 내용
  private String mtgCn;

  //시작 일시
  private Timestamp mtgBgngDt;

  //종료 일시
  private Timestamp mtgEndDt;

  //상태
  private String mtgStts;

  private List entry;

  private String entryName;

  //반복 여부
//  private String reptYn;

  //반복 주기
 // private String retp;

  //등록 사용자 ID
// private String rgstUserId;

  //등록 사용자 IP
 // private String rgstUserIp;

  //등록 일시
 // private Timestamp rgstDtm;

  //수정 사용자 ID
//  private String updUserId;

  //수정 사용자 IP
 // private String updUserIp;

  //수정 일시
  //private Timestamp updDtm;

  //조직번호
//  private BigDecimal ognzNo;

  //조직명
//  private String ognzNm;

  //직급 고유 번호
 // private BigDecimal jbgdNo;

  //직급 명
//  private Timestamp jbgdNm;

}
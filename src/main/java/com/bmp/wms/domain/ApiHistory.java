package com.bmp.wms.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * author   : jsper
 * fileName : ApiHistory
 * since    : 2024-03-01
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiHistory {
    // API 이력 일련번호
    private Long apiNo;
    // 트랜잭션 아이디
    private String transactionId;
    // API 명
    private String apiNm;
    // 요청 시스템 명
    private String requestSystem;
    // 요청 시작 일시
    private Timestamp requestDtm;
    // 외부 API URL
    private String outsideApiNm;
    // 외부 API 호출 일시
    private Timestamp outsideApiCallDtm;
    // 요청 종료 일시
    private Timestamp createDtm;
    // 응답 결과
    private String responseResult;
    // 결과 코드
    private String resultCode;
    // 요청 내용 데이터
    private String requestDesc;
    // 응답 내용 데이터
    private String responseDesc;
    // 등록 사용자 IP
    private String rgstUserIp;
    // 등록 일시
    private Timestamp rgstDtm;
}

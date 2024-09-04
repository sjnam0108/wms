package com.bmp.wms.model.WelcomeMsg;

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
public class WelcomeMsgResponse {

    /**
     * 웰컴메세지 번호
     */
    private BigDecimal wlcmMsgUnqNo;

    /**
     *  회의 예약 번호
     */
    private BigDecimal mtgRsvtUnqNo;

    /**
     * 메시지 내용
     */
    private String msg_cn;

    /**
     * 사용 여부
     */
    private String useYn;

    /**
     * 파일 저장 경로
     */
    private String fileUrl;

    /**
     *  원본 파일 명
     */
    private String fileOrgNm;

    /**
     * 저장 파일 명
     */
    private String fileSaveNm;

    /**
     * 노룰날짜
     */
    private Timestamp dpBgngDt;

    /**
     * 노룰날짜
     */
    private Timestamp dpEndDt;

    /**
     * 등록 사용자 ID
     */
    private String rgstUserId;

    /**
     * 등록 사용지 IP
     */
    private String rgstUserIp;

    /**
     * 등록 날짜
     */
    private String rgstDtm;

    /**
     * 수정 사용지 ID
     */
    private String updUserId;

    /**
     * 수정 사용자 IP
     */
    private String updUserIp;

    /**
     * 수정 날짜
     */
    private String updDtm;


}
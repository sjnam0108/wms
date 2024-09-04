package com.bmp.wms.domain;

import com.bmp.wms.model.meeting.MeetingResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

/**
 * 사용자 정보를 담는 클래스입니다.
 * <p>
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attend {

    /**
     * 웰컴메세지 번호
     */
    private BigDecimal mtgAtndNo;

    /**
     *  회의 예약 번호
     */
    private BigDecimal usrNo;

    /**
     * 메시지 내용
     */
    private BigDecimal mtgRsvtUnqNo;

    /**
     * 사용 여부
     */
    private BigDecimal mtgSeatUnqNo;

    /**
     * 파일 저장 경로
     */
    private BigDecimal vstrUnqNo;

    /**
     *  원본 파일 명
     */
    private BigDecimal ognzNo;

    /**
     * 저장 파일 명
     */
    private String ognzNm;

    /**
     * 노룰날짜
     */
    private BigDecimal jbgdNo;

    /**
     * 노룰날짜
     */
    private String jbgoNm;

    /**
     * 등록 사용자 ID
     */
    private List entry;

}
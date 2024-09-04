package com.bmp.wms.domain;

import com.bmp.wms.model.meeting.MeetingResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collections;
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
public class Meeting {

    /**
     * 회의예약 고유번호
     */
    private BigDecimal mtgRsvtUnqNo;

    /**
     * 웰컴메시지 번호
     */
    private BigDecimal wlcmMsgUnqNo;

    /**
     * 사용자 번호
     */
    private BigDecimal usrNo;

    /**
     * 회의 주최자
     */
    private String agent;

    /**
     * 회의 제목
     */
    private String title;

    /**
     * 회의 내용
     */
    private String contents;

    /**
     * 시작 일시
     */
    private Timestamp meetingStartDate;

    /**
     * 종료 일시
     */
    private Timestamp meetingEndDate;

    /**
     * 회의 유형
     */
    private String camMeeting;

    /**
     * 상태
     */
    private String mtgStts;

    /**
     * 반복 여부
     */
    private String reptYn;

    /**
     * 반복 주기
     */
    private String retp;

    /**
     * 등록 사용자 ID
     */
    private String declare;

    /**
     * 등록 사용자 IP
     */
    private String rgstUserIp;

    /**
     * 등록 일시
     */
    private Timestamp rgstDtm;

    /**
     * 수정 사용자 ID
     */
    private String updUserId;
    /**
     * 수정 사용자 IP
     */
    private String updUserIp;
    /**
     * 수정 일시
     */
    private Timestamp updDtm;
    /**
     * 조직번호
     */
    private BigDecimal ognzNo;
    /**
     * 조직명
     */
    private String ognzNm;
    /**
     * 직급 고유 번호
     */
    private BigDecimal jbgdNo;

    /**
     * 직급 명
     */
    private String jbgdNm;


    private String welcomeMsg;

    private String mtgSprvsn;

    private String mtgTtl;

    private String mtgCn;

    private Timestamp mtgBgngDt;

    private Timestamp mtgEndDt;

    private List entry;

    private String entryName;

    /**
     * User 엔티티를 UserResponse DTO로 변환합니다.
     *
     * @return MeetingResponse DTO
     */
    public MeetingResponse toDto() {
        return MeetingResponse.builder()
            .mtgStts(this.mtgStts)
            .mtgSprvsn(this.mtgSprvsn)
            .mtgTtl(this.mtgTtl)
            .mtgCn(this.mtgCn)
            .mtgBgngDt(this.mtgBgngDt)
            .mtgEndDt(this.mtgEndDt)
            .mtgRsvtUnqNo(this.mtgRsvtUnqNo)
            .wlcmMsgUnqNo(this.wlcmMsgUnqNo)
            .usrNo(this.usrNo)
            .build();
    }


}
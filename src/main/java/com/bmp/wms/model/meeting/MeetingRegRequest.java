package com.bmp.wms.model.meeting;

import ch.qos.logback.classic.Logger;
import com.bmp.wms.domain.Attend;
import com.bmp.wms.domain.Meeting;
import com.bmp.wms.domain.WelcomeMsg;
import com.bmp.wms.util.CommUtil;
import com.bmp.wms.util.DateUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;
import java.sql.Array;
import java.util.List;

@Data
@Slf4j
public class MeetingRegRequest {
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
    private String meetingStartDate;

    /**
     * 종료 일시
     */
    private String meetingEndDate;

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
    private String rgstDtm;

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
    private String updDtm;
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
    /**
     * 웰컴 메시지
     */
    private String welcomeMsg;
    /**
     * 월컴 메시지 노출 시작
     */
    private String welcomeMsgStartDate;
    /**
     *  웰컴 메시지 노출 종료
     */
    private String welcomeMsgEndDate;
    /**
     *  참석자 이름
     */
    private List entry;

    public Meeting toEntity(BigDecimal mtgRsvtUnqNo) {
        HttpServletRequest request = null;
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String clientIp = CommUtil.getClientIp(request);
        return Meeting.builder()
                .mtgRsvtUnqNo(mtgRsvtUnqNo)
                .wlcmMsgUnqNo(this.wlcmMsgUnqNo)
                .usrNo(this.usrNo)
                .agent(this.agent)
                .title(this.title)
                .contents(this.contents)
                .meetingStartDate(DateUtil.StringToTimestamp(this.meetingStartDate))
                .meetingEndDate(DateUtil.StringToTimestamp(this.meetingEndDate))
                .camMeeting(this.camMeeting)
                .mtgStts(this.mtgStts)
                .reptYn(this.reptYn)
                .retp(this.retp)
                .declare(this.declare)
                .rgstUserIp(clientIp)
                .updUserIp(clientIp)
                .ognzNo(this.ognzNo)
                .ognzNm(this.ognzNm)
                .jbgdNo(this.jbgdNo)
                .jbgdNm(this.jbgdNm)
                .build();
    }

    public WelcomeMsg toEntity2(BigDecimal mtgWelcomeUnqNo) {
        HttpServletRequest request = null;
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String clientIp = CommUtil.getClientIp(request);
        return WelcomeMsg.builder()
                .wlcmMsgUnqNo(mtgWelcomeUnqNo)
                .mtgRsvtUnqNo(this.mtgRsvtUnqNo)
                .welcomeMsg(this.welcomeMsg)
                .welcomeMsgStartDate(DateUtil.StringToTimestamp(this.welcomeMsgStartDate))
                .welcomeMsgEndDate(DateUtil.StringToTimestamp(this.welcomeMsgEndDate))
                .declare(this.declare)
                .rgstUserIp(clientIp)
                .updUserIp(clientIp)
                .build();
    }

    public Attend toEntity3(BigDecimal mtgAtndNo) {
        HttpServletRequest request = null;
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String clientIp = CommUtil.getClientIp(request);
        return Attend.builder()
                .mtgAtndNo(mtgAtndNo)
                .usrNo(this.usrNo)
                .mtgRsvtUnqNo(this.mtgRsvtUnqNo)
                .ognzNo(this.ognzNo)
                .ognzNm(this.ognzNm)
                .jbgdNo(this.jbgdNo)
                .jbgoNm(this.jbgdNm)
                .entry(this.entry)
                .build();
    }

}

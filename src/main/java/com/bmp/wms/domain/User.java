package com.bmp.wms.domain;

import com.bmp.wms.model.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

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
public class User {

    /**
     * 사용자 번호
     */
    private BigDecimal usrNo;

    /**
     * 사용자 ID
     */
    private String usrId;

    /**
     * 테넌트 ID
     */
    private String tnntId;

    /**
     * 사용자 이름
     */
    private String nm;

    /**
     * 휴대폰 번호
     */
    private String mblTelNo;

    /**
     * 전화 번호
     */
    private String telNo;

    /**
     * 사용자 유형
     */
    private String usrType;

    /**
     * 계정 사용 시작일
     */
    private Timestamp acntUseBgngDay;

    /**
     * 계정 사용 종료일
     */
    private Timestamp acntUseEndDay;

    /**
     * 직업 구분 코드
     */
    private String jbgdNo;

    /**
     * 직급 코드
     */
    private String jbttlCd;

    /**
     * 우편번호
     */
    private String zip;

    /**
     * 기본 주소
     */
    private String bscAddr;

    /**
     * 상세 주소
     */
    private String dtlAddr;

    /**
     * 상태 (정상, 정지 등)
     */
    private String stts;

    private String eml;

    private String confirm;

    private String prflFileUrl;

    private String prflOrgFileNm;

    private String prflSaveFileNm;

    /**
     * 마지막 연결 시간
     */
    private Timestamp lastCntnDt;

    /**
     * 등록 사용자 ID
     */
    private String rgstUserId;

    /**
     * 등록 사용자 IP 주소
     */
    private String rgstUserIp;

    /**
     * 등록 시간
     */
    private Timestamp rgstDtm;

    /**
     * 수정 사용자 ID
     */
    private String updUserId;

    /**
     * 수정 사용자 IP 주소
     */
    private String updUserIp;

    /**
     * 수정 시간
     */
    private Timestamp updDtm;

    /**
     * User 엔티티를 UserResponse DTO로 변환합니다.
     *
     * @return UserResponse DTO
     */
    public UserResponse toDto() {
        return UserResponse.builder()
            .usrNo(this.usrNo)
            .usrId(this.usrId)
            .tnntId(this.tnntId)
            .nm(this.nm)
            .mblTelNo(this.mblTelNo)
            .telNo(this.telNo)
            .usrType(this.usrType)
            .acntUseBgngDay(this.acntUseBgngDay)
            .acntUseEndDay(this.acntUseEndDay)
            .jbgdNo(this.jbgdNo)
            .jbttlCd(this.jbttlCd)
            .zip(this.zip)
            .bscAddr(this.bscAddr)
            .dtlAddr(this.dtlAddr)
            .stts(this.stts)
            .eml(this.eml)
            .confirm(this.confirm)
            .prflFileUrl(this.prflFileUrl)
            .prflOrgFileNm(this.prflOrgFileNm)
            .prflSaveFileNm(this.prflSaveFileNm)
            .lastCntnDt(this.lastCntnDt)
            .rgstUserId(this.rgstUserId)
            .rgstUserIp(this.rgstUserIp)
            .rgstDtm(this.rgstDtm)
            .updUserId(this.updUserId)
            .updUserIp(this.updUserIp)
            .updDtm(this.updDtm)
            .build();
    }


}
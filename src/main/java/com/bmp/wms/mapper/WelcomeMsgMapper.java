package com.bmp.wms.mapper;

import com.bmp.wms.domain.Meeting;
import com.bmp.wms.domain.WelcomeMsg;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

/**
 * 사용자 정보에 대한 데이터베이스 접근 맵퍼입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Mapper
public interface WelcomeMsgMapper {

	BigDecimal getNextWelcomeMsgSeq();

	void createWelcomeMsg(WelcomeMsg welcomeMsg);

}

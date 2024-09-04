package com.bmp.wms.mapper;

import com.bmp.wms.domain.Meeting;
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
public interface MeetingMapper {

	/**
	 * 다음 사용자 시퀀스 번호를 가져옵니다.
	 *
	 * @return 다음 사용자 시퀀스 번호
	 */
	BigDecimal getNextMeetingSeq();

	void createMeeting(Meeting meeting);
	/**
	 * 사용자 로그인 ID로 사용자 정보를 가져옵니다.
	 *
	 * @param usrId 사용자 로그인 ID
	 * @return 사용자 정보
	 */
	Meeting getMeetingByUserId(String usrId);

}

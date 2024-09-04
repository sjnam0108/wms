package com.bmp.wms.service;

import com.bmp.wms.api.ResultCode;
import com.bmp.wms.domain.Attend;
import com.bmp.wms.domain.Meeting;
import com.bmp.wms.domain.WelcomeMsg;
import com.bmp.wms.exception.ApiException;
import com.bmp.wms.mapper.AttendMapper;
import com.bmp.wms.mapper.MeetingMapper;
import com.bmp.wms.mapper.WelcomeMsgMapper;
import com.bmp.wms.model.meeting.MeetingRegRequest;
import com.bmp.wms.model.meeting.MeetingResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class MeetingService {
    private final MeetingMapper meetingMapper;
    private final WelcomeMsgMapper welcomeMsgMapper;
    private final AttendMapper attendMapper;

    /**
     * 회원가입을 수행합니다.
     *
     * @param meetingRegRequset 회원가입 요청 정보
     * @throws ApiException 에러 발생 시 예외를 던집니다.
     */
    public void createMeeting(MeetingRegRequest meetingRegRequset) {


        BigDecimal nextWelcomeMsgSeq = welcomeMsgMapper.getNextWelcomeMsgSeq();
        BigDecimal nextMeetingSeq = meetingMapper.getNextMeetingSeq();
        BigDecimal nextAttendSeq = attendMapper.getNextAttendSeq();

        WelcomeMsg welcomeMsgReg = meetingRegRequset.toEntity2(nextWelcomeMsgSeq);
        Meeting meetingReg = meetingRegRequset.toEntity(nextMeetingSeq);
        Attend attendReg = meetingRegRequset.toEntity3(nextAttendSeq);

        welcomeMsgMapper.createWelcomeMsg(welcomeMsgReg);
        meetingMapper.createMeeting(meetingReg);
        attendMapper.createAttend(attendReg);
    }
    /**
     * 내 정보를 조회합니다.
     *
     * @param userId 사용자 ID
     * @return 사용자 정보
     * @throws ApiException 에러 발생 시 예외를 던집니다.
     */
    public MeetingResponse getMeetingByUserId(String usrId) {
        Meeting meeting = meetingMapper.getMeetingByUserId(usrId);
        if (meeting == null) {
            throw new ApiException(ResultCode.WMS_USER_NOT_FOUND);
        }
        return meeting.toDto();
    }


}

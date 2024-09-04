package com.bmp.wms.controller;

import com.bmp.wms.api.BaseResponse;
import com.bmp.wms.api.ResultCode;
import com.bmp.wms.model.meeting.MeetingRegRequest;
import com.bmp.wms.model.meeting.MeetingResponse;
import com.bmp.wms.service.MeetingService;
import com.bmp.wms.service.WelcomeMsgService;
import com.bmp.wms.util.Const;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "회의실", description = "회의실 API Document")
public class MeetingController {

    private final MeetingService meetingService;
    private final WelcomeMsgService welcomeMsgService;

    @PostMapping("/meeting-rooms/{meetingRoomId}/reservations")
    public BaseResponse<Void> createMeeting(
            @RequestBody @Valid MeetingRegRequest meetingRegRequset,
            HttpServletRequest httpServletRequest
    ) {
        meetingService.createMeeting(meetingRegRequset);
        return BaseResponse.<Void>builder()
                .transactionId(MDC.get(Const.LOG_KEY))
                .returnCode(ResultCode.WMS_SUCCESS.getCode())
                .returnDescription(ResultCode.WMS_SUCCESS.getMessage())
                .build();
    }

    /**
     * 내 정보 조회 API
     *
     * @param request HTTP 요청 객체
     * @param usrId   사용자 ID
     * @return 내 정보 응답
     * @throws Exception 내 정보 조회 과정에서 발생한 예외
     */
    @GetMapping("/meeting-rooms/{usrId}")
    public BaseResponse<MeetingResponse> getMeetingByMeetingId(
            HttpServletRequest request,
            @PathVariable String usrId
    ) throws Exception {
        MeetingResponse response = meetingService.getMeetingByUserId(usrId);
        return BaseResponse.<MeetingResponse>builder()
                .transactionId(MDC.get(Const.LOG_KEY))
                .returnCode(ResultCode.WMS_SUCCESS.getCode())
                .returnDescription(ResultCode.WMS_SUCCESS.getMessage())
                .response(response)
                .build();
    }



}

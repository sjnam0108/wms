package com.bmp.wms.controller;

import com.bmp.wms.api.BaseResponse;
import com.bmp.wms.api.ResultCode;
import com.bmp.wms.model.user.UserResponse;
import com.bmp.wms.service.UserService;
import com.bmp.wms.util.Const;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 사용자 정보를 처리하는 컨트롤러입니다.
 * <p>
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@RestController
@RequiredArgsConstructor
@Slf4j
@Tag(name = "사용자", description = "사용자 API Document")
public class UserController {
    private final UserService userService;
    
    /**
     * 내 정보 조회 API
     *
     * @param request HTTP 요청 객체
     * @param usrId   사용자 ID
     * @return 내 정보 응답
     * @throws Exception 내 정보 조회 과정에서 발생한 예외
     */
    @GetMapping("/comm/user/{usrId}")
    public BaseResponse<UserResponse> getUserByUsrId(
        HttpServletRequest request,
        @PathVariable String usrId
    ) throws Exception {
        UserResponse response = userService.getUserByUsrId(usrId);
        return BaseResponse.<UserResponse>builder()
                .transactionId(MDC.get(Const.LOG_KEY))
                .returnCode(ResultCode.WMS_SUCCESS.getCode())
                .returnDescription(ResultCode.WMS_SUCCESS.getMessage())
                .response(response)
                .build();
    }

}

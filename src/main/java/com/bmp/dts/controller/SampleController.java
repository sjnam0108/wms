package com.bmp.dts.controller;

import com.bmp.dts.dto.BaseResponse;
import com.bmp.dts.dto.ResultCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/check")
    public ResponseEntity<BaseResponse<Void>> check() {
        return ResponseEntity.ok()
            .body(BaseResponse.<Void>builder()
                .resultCode(ResultCode.UMP_SUCCESS.getCode())
                .message("wms Hello World!")
                .build());
    }
}

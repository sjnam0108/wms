package com.bmp.wms.controller;


import com.bmp.wms.api.BaseResponse;
import com.bmp.wms.api.ResultCode;
import com.bmp.wms.util.Const;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

    @GetMapping("/check")
    public BaseResponse<Void> check() {
        return BaseResponse.<Void>builder()
            .transactionId(MDC.get(Const.LOG_KEY))
            .returnCode(ResultCode.WMS_SUCCESS.getCode())
            .returnDescription("wms Hello World !")
            .build();
    }
}

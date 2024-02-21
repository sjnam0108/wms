package com.bmp.dts.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCode {

    UMP_SUCCESS("0", "성공")

    ;

    private String code;
    private String message;
}


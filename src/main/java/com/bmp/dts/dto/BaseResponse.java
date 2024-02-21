package com.bmp.dts.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BaseResponse<T> {
    private String resultCode;
    private String message;
    private T data;
}

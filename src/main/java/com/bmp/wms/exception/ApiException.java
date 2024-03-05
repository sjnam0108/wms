package com.bmp.wms.exception;

import com.bmp.wms.api.ResultCode;
import lombok.Getter;

/**
 * API 예외 클래스입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Getter
public class ApiException extends RuntimeException {

	/**
	 * 에러 코드입니다.
	 */
	private String code;

	/**
	 * 에러 메시지입니다.
	 */
	private String message;

	/**
	 * ResultCode 객체를 기반으로 ApiException을 생성합니다.
	 *
	 * @param resultCode 에러 코드 정보
	 */
	public ApiException(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.message = resultCode.getMessage();
	}
}

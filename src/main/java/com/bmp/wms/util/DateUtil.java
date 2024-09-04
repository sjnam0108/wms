package com.bmp.wms.util;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtil {

    /**
     * YYYY-MM-DD 형식의 문자열을 Timestamp으로 변환합니다.
     *
     * @param dateString YYYY-MM-DD 형식의 문자열
     * @return Timestamp 변환된 Timestamp 객체
     * @throws IllegalArgumentException 문자열 형식이 올바르지 않거나 날짜가 유효하지 않을 경우
     */
    public static Timestamp StringToTimestamp(String dateString) {
        LocalDateTime localDateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss"));
        Instant instant = localDateTime.atZone(ZoneId.of("Asia/Seoul")).toInstant();
        return Timestamp.from(instant);
    }
}

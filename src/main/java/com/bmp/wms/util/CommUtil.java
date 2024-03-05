package com.bmp.wms.util;

import jakarta.servlet.http.HttpServletRequest;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 공통 유틸리티 클래스입니다.
 *
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
public class CommUtil {
    
    /**
     * 트랜잭션 ID 생성
     * @return
     */
    public static String generateTransactionId() {
        return UUID.randomUUID().toString();
    }

    /**
     * 현재 시간을 java.sql.Timestamp 형식으로 반환
     *
     * @return 현재 시간의 타임스탬프
     */
    public static Timestamp getCurrentTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    
    /**
     * 클라이언트 IP 조회
     *
     * @param request request
     * @return String IP
     */
    public static String getClientIp(HttpServletRequest request) {

        String ipAddress = request.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }

        return ipAddress;
    }

    
    /**
     * 사용자 비밀번호 유효성 검사를 수행합니다.
     *
     * @param id 사용자 ID
     * @param pw 비밀번호
     * @param pw_re 비밀번호 재입력
     * @return int
     */
    public static int chkUserPassword(String id, String pw, String pw_re) {

        // 1. 3종류 이상의 문자 조합
        String pattern = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*[!@#$%^*?_~])[\\w!@#$%^*?_~]+$";

        if (!pw.matches(pattern)) {
            return -1;
        }

        // 2. 최소 8자리 이상 ~ 16자리까지
        if (pw.length() < 8 || pw.length() > 16) {
            return -2;
        }

        // 3. 공백 체크
        if (chkHasSpace(pw)) {
            return -3;
        }

        // 4. 단순 비밀번호 불가
        // 4-1 ID와 4글자 이상 중복
        if (chkDupIdPw(id, pw)) {
            return -41;
        }

        // 4-2 숫자, 문자의 4자리 이상 연속/중복
        if (isSameContinuedValue(pw)) {
            return -42;
        }

        if (!pw_re.isEmpty()) {
            // 5. 비밀번호 <-> 비밀번호 재입력 항목 일치 여부 확인
            if (!pw.equals(pw_re)) {
                return -5;
            }
        }

        // 6. id와 비밀번호는 동일할 수 없다
        if (pw.indexOf(id) > -1 || id.indexOf(pw) > -1) {
            return -6;
        }

        // 7. 신규 비밀번호와 기존 비밀번호는 같을 수 없다.
        if (!pw_re.isEmpty()) {
            if (pw.equals(pw_re)) {
                return -7;
            }
        }

        return 0;
    }

    /**
     * chkDupIdPw - id와 패스워드가 4자리 이상 중복 여부 반환
     *
     * @param id
     * @param pw
     * @return boolean
     */
    private static boolean chkDupIdPw(String id, String pw) {
        // 중복 체크를 위한 문자 카운트
        Map<Character, Integer> charCount = new HashMap<>();

        int count = 0;

        // id 문자열에서 각 문자의 개수를 세기
        for (char c : id.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0));
        }

        // pw 문자열에서 중복되는 문자가 있는지 확인
        for (char c : pw.toCharArray()) {
            if (charCount.containsKey(c)) {
                count++;
                System.out.println(count);
                if (count >= 4) {
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * isSameContinuedValue - 4자리 이상의 연속 된 문자열 포함 여부 반환
     *
     * @param passwd
     * @return boolean
     */
    private static boolean isSameContinuedValue(String passwd) {
        int length = passwd.length();
        if (length < 4) {
            return false; // 패스워드 길이가 4 미만인 경우는 체크할 필요 없음
        }

        for (int i = 0; i <= length - 4; i++) {
            char c1 = passwd.charAt(i);
            char c2 = passwd.charAt(i + 1);
            char c3 = passwd.charAt(i + 2);
            char c4 = passwd.charAt(i + 3);

            if (c1 == c2 && c2 == c3 && c3 == c4) {
                return true; // 4자리 동일한 문자가 연속적으로 있는 경우
            }
        }

        return false; // 4자리 동일한 문자가 연속적으로 없는 경우
    }

    /**
     * chkHasSpace - 문자열 내 공백 포함 여부 반환
     *
     * @param val
     * @return boolean
     */
    public static boolean chkHasSpace(String val) {
        for (int i = 0; i < val.length(); i++) {
            if (val.charAt(i) == ' ')
                return true;
        }
        return false;
    }
}


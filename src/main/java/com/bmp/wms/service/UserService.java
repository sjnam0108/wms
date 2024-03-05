package com.bmp.wms.service;

import com.bmp.wms.api.ResultCode;
import com.bmp.wms.domain.User;
import com.bmp.wms.mapper.UserMapper;
import com.bmp.wms.model.user.UserResponse;
import com.bmp.wms.util.PageUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bmp.wms.exception.ApiException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 사용자 서비스 클래스입니다.
 * <p>
 * author : dayworker
 * version : 1.0
 * date : 2024-02-08
 */
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService {
    private final UserMapper userMapper;


    /**
     * 내 정보를 조회합니다.
     *
     * @param usrId 사용자 ID
     * @return 사용자 정보
     * @throws ApiException 에러 발생 시 예외를 던집니다.
     */
    public UserResponse getUserByUsrId(String usrId) {
        User user = userMapper.getUserByUsrId(usrId);
        if (user == null) {
            throw new ApiException(ResultCode.WMS_USER_NOT_FOUND);
        }
        return user.toDto();
    }

}

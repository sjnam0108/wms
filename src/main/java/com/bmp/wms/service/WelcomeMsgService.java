package com.bmp.wms.service;

import com.bmp.wms.domain.WelcomeMsg;
import com.bmp.wms.mapper.WelcomeMsgMapper;
import com.bmp.wms.model.WelcomeMsg.WelcomeMsgRegRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class WelcomeMsgService {
    private final WelcomeMsgMapper welcomeMsgMapper;
    public void createWelcomeMsg(WelcomeMsgRegRequest welcomeMsgRegRequset) {
        BigDecimal nextWelcomeMsgSeq = welcomeMsgMapper.getNextWelcomeMsgSeq();

        WelcomeMsg welcomeMsgReg = welcomeMsgRegRequset.toEntity(nextWelcomeMsgSeq);
        welcomeMsgMapper.createWelcomeMsg(welcomeMsgReg);
    }
}

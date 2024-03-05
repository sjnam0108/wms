package com.bmp.wms.service;

import com.bmp.wms.domain.ApiHistory;
import com.bmp.wms.mapper.ApiHistoryMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * author   : jsper
 * fileName : AppService
 * since    : 2024-02-17
 */
@Service
@Slf4j
@RequiredArgsConstructor
@Transactional()
public class ApiHistoryService {

    private final ApiHistoryMapper apiHistoryMapper;

    public void createApiHistory(
        ApiHistory apiHistory
    ) {
        apiHistoryMapper.createApiHistory(apiHistory);
    }

}

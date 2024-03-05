package com.bmp.wms.mapper;

import com.bmp.wms.domain.ApiHistory;
import org.apache.ibatis.annotations.Mapper;

/**
 * author   : jsper
 * fileName : AppMapper
 * since    : 2024-02-17
 */
@Mapper
public interface ApiHistoryMapper {

    void createApiHistory(ApiHistory apiHistory);

}

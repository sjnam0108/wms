package com.bmp.wms.model.attend;

import com.bmp.wms.domain.Attend;
import com.bmp.wms.domain.WelcomeMsg;
import com.bmp.wms.util.CommUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;

@Data
public class AttendRegRequest {


    public Attend toEntity(BigDecimal mtgAtndNo) {
        HttpServletRequest request = null;
        request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String clientIp = CommUtil.getClientIp(request);
        return Attend.builder()
                .build();
    }
}

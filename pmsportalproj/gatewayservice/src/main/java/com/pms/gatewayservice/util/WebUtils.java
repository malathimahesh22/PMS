package com.pms.gatewayservice.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



public class WebUtils {

    private static HttpServletRequest request;

    @Autowired
    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public static String getClientIp() {

        String remoteAddr = "";

        if (request != null) {
            remoteAddr = request.getHeader("X-FORWARDED-FOR");
            if (remoteAddr == null || "".equals(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();
            }
        }

        return remoteAddr;
    }

}
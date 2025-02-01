package com.sims.ppob.utils;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;

@Component
public class CookieUtil {
  @Value("${silent-meeting.configuration.cookie.max-age}")
  private long cookieMaxAge;

  public ResponseCookie createCookie(String name, String value) {
    return ResponseCookie.from(name, value)
        .httpOnly(false)
        .secure(false)
        .path("/")
        .maxAge(cookieMaxAge)
        .build();
  }

  public void addCookieToResponse(HttpServletResponse servletResponse, ResponseCookie cookie){
    servletResponse.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
  }
}

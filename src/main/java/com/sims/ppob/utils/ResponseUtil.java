package com.sims.ppob.utils;

import com.sims.ppob.models.dtos.CommonResponseDto;

public class ResponseUtil {
  public static <T> CommonResponseDto<T> createResponse(Integer httpStatus, String message) {
    return CommonResponseDto.<T>builder()
        .status(httpStatus)
        .message(message)
        .build();
  }
}

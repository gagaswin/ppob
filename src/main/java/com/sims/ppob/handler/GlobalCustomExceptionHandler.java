package com.sims.ppob.handler;

import com.sims.ppob.exceptions.UserAlreadyExistsException;
import com.sims.ppob.models.dtos.CommonResponseDto;
import com.sims.ppob.utils.ResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCustomExceptionHandler {
  @ExceptionHandler(exception = UserAlreadyExistsException.class)
  public ResponseEntity<CommonResponseDto<String>> handleUserAlreadyExistsException(UserAlreadyExistsException e) {
    return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(ResponseUtil.createResponse(HttpStatus.CONFLICT.value(), e.getMessage()));
  }
}

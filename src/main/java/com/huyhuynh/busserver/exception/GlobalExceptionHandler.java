package com.huyhuynh.busserver.exception;

import com.huyhuynh.busserver.entity.AccountInfoEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Xử lý khi gặp lỗi vi phạm ràng buộc dữ liệu
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiResponse<String>> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
        ApiResponse<AccountInfoEntity> response = ApiResponse.error(List.of(ex.getMessage()));
        // Kiểm tra xem lỗi có phải do vi phạm unique constraint
        if (ex.getMessage().contains("duplicate")) {
            return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // Xử lý lỗi chung
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("Đã xảy ra lỗi: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

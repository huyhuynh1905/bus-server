package com.huyhuynh.busserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    
    @JsonProperty("success")
    private Boolean success;
    
    @JsonProperty("data")
    private T data;
    
    @JsonProperty("messages")
    private List<String> errors;
    
    @JsonProperty("typeCard")
    private String typeCard;

    // Phương thức static để tạo response thành công
    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .build();
    }

    // Phương thức static để tạo response thất bại
    public static <T> ApiResponse<T> error(List<String> errors) {
        return ApiResponse.<T>builder()
                .success(false)
                .errors(errors)
                .build();
    }

    // Phương thức static để tạo response với typeCard
    public static <T> ApiResponse<T> withTypeCard(T data, String typeCard) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .typeCard(typeCard)
                .build();
    }
} 
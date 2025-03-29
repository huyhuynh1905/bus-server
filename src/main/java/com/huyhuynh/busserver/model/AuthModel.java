package com.huyhuynh.busserver.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthModel {
    private String accessToken;
    private Long expired;
    private String tokenType;
}

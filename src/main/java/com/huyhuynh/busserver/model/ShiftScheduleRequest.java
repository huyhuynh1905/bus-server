package com.huyhuynh.busserver.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShiftScheduleRequest {
    private String sellerId;
    private String schedulerTime;
    public String sessionToken;
}

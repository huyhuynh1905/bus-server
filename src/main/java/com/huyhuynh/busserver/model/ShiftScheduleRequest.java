package com.huyhuynh.busserver.model;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ShiftScheduleRequest {
    private String sellerIdCard;
    private String scheduleTime;
    private String sessionToken;
}

package com.huyhuynh.busserver.model;

import com.huyhuynh.busserver.entity.DataLogEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataLogRequest {
    private String sellerIdCard;

    private Long routeId;

    private String scheduleId;

    private Long shiftSchedulerId;

    private String goBack;

    private String syncDate;

    private String type;

    public DataLogEntity toEntity(){
        return new DataLogEntity(null,this.sellerIdCard,this.routeId,this.scheduleId,this.shiftSchedulerId,Integer.parseInt(this.goBack),this.syncDate,this.type);
    }
}

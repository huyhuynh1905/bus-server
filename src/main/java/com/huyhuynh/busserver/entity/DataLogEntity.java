package com.huyhuynh.busserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "data_log")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DataLogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seller_id_card", nullable = false, length = 20)
    private String sellerIdCard;

    @Column(name = "route_id", nullable = false, unique = true, length = 100)
    private Long routeId;

    @Column(name = "schedule_id", nullable = false)
    private String scheduleId;

    @Column(name = "shift_scheduler_id", nullable = false)
    private Long shiftSchedulerId;

    @Column(name = "go_back", nullable = false)
    private Integer goBack;

    @Column(name = "sync_date")
    private String syncDate;

    @Column(name = "type")
    private String type;
}

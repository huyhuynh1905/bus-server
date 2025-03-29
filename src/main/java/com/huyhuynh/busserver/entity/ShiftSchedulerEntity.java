package com.huyhuynh.busserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "shift_schedule")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShiftSchedulerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "driver_license")
    private String driverLicense;

    @Column(name = "go_back")
    private Integer goBack;

    @Column(name = "route_id")
    private Long routeId;

    @Column(name = "schedule_id", unique = true)
    private String scheduleId;

    @Column(name = "schedule_time")
    private String scheduleTime;

    @Column(name = "seller_id_card")
    private String sellerIdCard;

    @Column(name = "node")
    private String node;
}
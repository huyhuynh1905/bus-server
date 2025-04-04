package com.huyhuynh.busserver.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ticket_order")
@Getter
@Setter
public class TicketOrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "payment_method")
    private String paymentMethod;

    @Column(name = "serial_to")
    private String serialTo;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "name_bus_stop")
    private String nameBusStop;

    @Column(name = "time")
    private String time;

    @Column(name = "schedule_time")
    private String scheduleTime;

    @Column(name = "car_id")
    private String carId;

    @Column(name = "route_code")
    private String routeCode;

    @Column(name = "seller_id_card")
    private String sellerIdCard;

    @Column(name = "node")
    private String node;

    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "ticket_id")
    private Integer ticketId;

    @Column(name = "bus_stop_id")
    private Integer busStopId;

    @Column(name = "scheduler_id")
    private Integer schedulerId;

    @Column(name = "go_back")
    private Integer goBack;
}

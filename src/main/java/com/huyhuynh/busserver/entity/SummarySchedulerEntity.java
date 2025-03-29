package com.huyhuynh.busserver.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "summary_schedules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SummarySchedulerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_id", nullable = false)
    private Long ticketId;

    @Column(name = "route_id", nullable = false)
    private Long routeId;

    @Column(name = "schedule_id", nullable = false, length = 100, unique = true)
    private String scheduleId;

    @Column(name = "serial_to", nullable = false)
    private Integer serialTo;

    @Column(name = "total_amount", nullable = false)
    private Integer totalAmount;

    @Column(name = "total_quantity", nullable = false)
    private Integer totalQuantity;

    @Column(name = "go_back", nullable = false)
    private Integer goBack;

    @Column(name = "car_id", length = 50)
    private String carId;

    @Column(name = "driver_license", length = 100)
    private String driverLicense;

    @Column(name = "schedule_time", length = 25)
    private String scheduleTime;

    @Column(name = "node", length = 50)
    private String node;

    @Column(name = "seller_id_card", length = 50)
    private String sellerIdCard;

    @Column(name = "is_sync", nullable = false)
    private Integer isSync;

    @Column(name = "sync_date", length = 25)
    private String syncDate;

    @Column(name = "shift_scheduler_id", nullable = false)
    private Integer shiftSchedulerId;

}


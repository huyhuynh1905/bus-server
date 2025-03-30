package com.huyhuynh.busserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ticket_product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TicketProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "serial_format")
    private String serialFormat;

    @Column(name = "route_id", nullable = false)
    private Integer routeId;

    @Column(name = "description")
    private String description;

    @Column(name = "type", nullable = false)
    private String type;

    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "tem_thang_type")
    private String temThangType;

    @Column(name = "object_type")
    private String objectType;

    @Column(name = "is_multi_routes", nullable = false)
    private Boolean isMultiRoutes = false;

}

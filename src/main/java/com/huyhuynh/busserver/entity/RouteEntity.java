package com.huyhuynh.busserver.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RouteEntity {

    @Id
    private Long id;

    @Column(name = "provider_id", length = 50, nullable = false)
    private String providerId;

    @Column(name = "name_zh", length = 255, nullable = false)
    private String nameZh;

    @Column(name = "d_desc", length = 500)
    private String dDesc;

    @Column(name = "departure_zh", length = 500)
    private String departureZh;

    @Column(name = "destination_zh", length = 500)
    private String destinationZh;

    @Column(name = "gx_code", length = 100)
    private String gxCode;

    @Column(name = "route_map_image_url", length = 500)
    private String routeMapImageUrl;

    @Column(name = "time_schedule_url_weight", length = 500)
    private String timeScheduleUrlWeight;

    @Column(name = "op_type", length = 100)
    private String opType;

    @Column(name = "code", length = 100, nullable = false, unique = true)
    private String code;

    @Column(name = "cyber_route_id", length = 100)
    private String cyberRouteId;
}


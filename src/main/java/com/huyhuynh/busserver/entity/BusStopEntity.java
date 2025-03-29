package com.huyhuynh.busserver.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "bus_stop")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BusStopEntity {

    @Id
    private Long id;

    @Column(name = "route_id", nullable = false)
    private Integer routeId;

    @Column(name = "name_zh", length = 255)
    private String nameZh;

    @Column(name = "seq_no")
    private Integer seqNo;

    @Column(name = "pgp", length = 50)
    private String pgp;

    @Column(name = "terminal", length = 50)
    private String terminal;

    @Column(name = "district_id", length = 50)
    private String districtId;

    @Column(name = "go_back")
    private Integer goBack;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "ext_voice_no", length = 50)
    private String extVoiceNo;

    @Column(name = "sid")
    private Integer sid;

    @Column(name = "ivr_no")
    private Integer ivrNo;
}
package com.huyhuynh.busserver.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "pos_para")
@Getter
@Setter
public class PosParaEntity {
    @Id
    private Long id;

    @Column(name = "setting_type", nullable = false, length = 50)
    private String settingType;

    @Column(name = "setting_key", nullable = false, unique = true, length = 100)
    private String settingKey;

    @Column(name = "setting_value")
    private String settingValue;

    @Column(name = "description")
    private String description;

    @Column(name = "company_id", nullable = false)
    private Integer companyId;
}

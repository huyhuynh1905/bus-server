package com.huyhuynh.busserver.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bank_info")
@Getter
@Setter
public class BankInfoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Sử dụng auto_increment cho id
    private Long id;

    @Column(name = "code")
    private String code;

    @JsonProperty("ben_id")
    @Column(name = "ben_id")
    private String benId;

    @JsonProperty("bank_bin")
    @Column(name = "bank_bin")
    private String bankBin;

    @JsonProperty("short_name")
    @Column(name = "short_name")
    private String shortName;
}

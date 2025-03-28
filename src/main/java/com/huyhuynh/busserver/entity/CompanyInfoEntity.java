package com.huyhuynh.busserver.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Table(name = "company_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String companyName;

    private String companyCode;
    private String address;
    private String phone;
    private String email;
    private String website;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AccountInfoEntity> accounts = new ArrayList<>();
}

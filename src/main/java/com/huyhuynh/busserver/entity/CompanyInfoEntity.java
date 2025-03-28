package com.huyhuynh.busserver.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "company_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "system_code", length = 100)
    private String systemCode;

    @Column(name = "system_name", length = 100)
    private String systemName;

    @Column(name = "logo_file_name", length = 255)
    private String logoFileName;

    @Column(name = "logo_mini_repo_id")
    private Integer logoMiniRepoId;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "overview", columnDefinition = "TEXT")
    private String overview;

    @Column(name = "company_url", length = 255)
    private String companyUrl;

    @Column(name = "deputy", length = 100)
    private String deputy;

    @Column(name = "email", length = 255)
    private String email;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "tax_code", length = 50)
    private String taxCode;

    @Column(name = "city", length = 100)
    private String city;
}

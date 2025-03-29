package com.huyhuynh.busserver.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "account_info")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AccountInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "role")
    private String role;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "avatar")
    private String avatar;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "first_login")
    private Boolean firstLogin;

    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "id_card")
    private String idCard;

    @Column(name = "actived")
    private Integer actived;

    @Column(name = "locked")
    private Integer locked;

    // Quan hệ với CompanyInfoEntity (Mỗi tài khoản thuộc một công ty)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id",referencedColumnName = "id")
    private CompanyInfoEntity companyInfo;
}
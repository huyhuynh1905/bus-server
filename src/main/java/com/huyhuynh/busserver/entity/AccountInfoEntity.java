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

    @Column(unique = true, nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 255)
    private String password;

    private String fullName;
    private String phone;
    private String email;
    private String avatar;
    private String firstName;
    private String lastName;
    private String jobTitle;
    private Boolean firstLogin;
    private Integer routeId;
    private String idCard;
    private Integer actived;
    private Integer locked;

    @ManyToOne(fetch = FetchType.LAZY) // Nhiều account thuộc về một công ty
    @JoinColumn(name = "company_id", nullable = false) // Cột khóa ngoại trong bảng account_info
    private CompanyInfoEntity company;
}
package com.huyhuynh.busserver.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class AccountInfoDTO {

    private Long id;

    private String username;

    private String password;

    private String role;

    private String fullName;

    private String phone;

    private String email;

    private String firstName;

    private String lastName;

    private String jobTitle;

    private Boolean firstLogin;

    private Integer routeId;

    private String idCard;

    private Integer actived;

    private Integer locked;

    private Long companyId;

}
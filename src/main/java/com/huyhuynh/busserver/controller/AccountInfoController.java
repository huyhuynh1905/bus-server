package com.huyhuynh.busserver.controller;

import com.huyhuynh.busserver.model.AccountInfo;
import com.huyhuynh.busserver.services.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("account")
public class AccountInfoController {
    @Autowired
    private AccountInfoService accountInfoService;

    @GetMapping("/register")
    public String showRegisterPage() {
        return "register/register"; // Điều hướng đến file register.html trong thư mục static
    }

    @GetMapping("get-account-info")
    public AccountInfo getAccountInfo(String username) {
        return new AccountInfo();
    }
}

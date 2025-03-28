package com.huyhuynh.busserver.controller;

import com.huyhuynh.busserver.entity.CompanyInfoEntity;
import com.huyhuynh.busserver.services.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/companies")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @PostMapping("/create")
    public CompanyInfoEntity createCompany(
            @RequestParam String name,
            @RequestParam String code,
            @RequestParam String address,
            @RequestParam String phone,
            @RequestParam String email,
            @RequestParam String website
    ) {
        return companyInfoService.createCompany(name, code, address, phone, email, website);
    }
}

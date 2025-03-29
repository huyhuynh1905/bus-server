package com.huyhuynh.busserver.controller.api;

import com.huyhuynh.busserver.entity.CompanyInfoEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.services.CompanyInfoService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.apiPrePath + "/company")
public class CompanyInfoController {

    @Autowired
    private CompanyInfoService companyInfoService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<CompanyInfoEntity>> createCompany(@RequestBody CompanyInfoEntity company) {
        CompanyInfoEntity companyInfoEntity = companyInfoService.createCompany(company);
        ApiResponse<CompanyInfoEntity> successResponse = ApiResponse.success(companyInfoEntity);
        return ResponseEntity.ok(successResponse);
    }
}

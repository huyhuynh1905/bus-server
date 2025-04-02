package com.huyhuynh.busserver.controller.api;

import com.huyhuynh.busserver.dto.AccountInfoDTO;
import com.huyhuynh.busserver.entity.AccountInfoEntity;
import com.huyhuynh.busserver.entity.CompanyInfoEntity;
import com.huyhuynh.busserver.mapper.AccountInfoMapper;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.services.AccountInfoService;
import com.huyhuynh.busserver.services.CompanyInfoService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(Constants.apiPrePath +"/account")
public class AccountInfoController {
    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @Autowired
    private AccountInfoMapper accountInfoMapper;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AccountInfoEntity>> registerUser(@RequestBody AccountInfoDTO request) {
        AccountInfoEntity entity = accountInfoMapper.toEntity(request);
        CompanyInfoEntity companyInfo =  companyInfoService.getById(request.getCompanyId());
        entity.setCompanyInfo(companyInfo);
        AccountInfoEntity newUser = accountInfoService.registerUser(entity);
        newUser.setPassword("");

        // Response thành công
        ApiResponse<AccountInfoEntity> successResponse = ApiResponse.success(newUser);
        return ResponseEntity.ok(successResponse);

    }

    @PostMapping("/sign-out")
    public ResponseEntity<ApiResponse<Map<String,String>>> signOut(@RequestBody Map request) {
        System.out.println("signOut =======> "+request.toString());
        return ResponseEntity.ok(ApiResponse.success(Map.of()));

    }
}

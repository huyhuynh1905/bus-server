package com.huyhuynh.busserver.controller;

import com.huyhuynh.busserver.entity.AccountInfoEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.utils.Constants;
import com.huyhuynh.busserver.services.AccountInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.apiPrePath +"/account")
public class AccountInfoController {
    @Autowired
    private AccountInfoService accountInfoService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse<AccountInfoEntity>> registerUser(@RequestBody AccountInfoEntity request) {
        AccountInfoEntity newUser = accountInfoService.registerUser(request);
        // Response thành công
        ApiResponse<AccountInfoEntity> successResponse = ApiResponse.success(newUser);
        return ResponseEntity.ok(successResponse);

    }

    @GetMapping("/get-account-info")
    public AccountInfoEntity getAccountInfo(String username) {
        return new AccountInfoEntity();
    }
}

package com.huyhuynh.busserver.controller.pos;

import com.huyhuynh.busserver.entity.AccountInfoEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.services.AccountInfoService;
import com.huyhuynh.busserver.services.CompanyInfoService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constants.posApiPrePath +"/account")
public class AccountInfoPosController {
    @Autowired
    private AccountInfoService accountInfoService;

    @Autowired
    private CompanyInfoService companyInfoService;

    @GetMapping("/get-account-info")
    public ResponseEntity<ApiResponse<AccountInfoEntity>> getAccountInfo() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            if (authentication == null || !authentication.isAuthenticated()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ApiResponse.error(List.of(HttpStatus.UNAUTHORIZED.getReasonPhrase())));
            }
            String username = authentication.getName(); // Lấy username từ token
            // Tìm tài khoản trong DB
            AccountInfoEntity account = accountInfoService.getByUsername(username);
            ApiResponse<AccountInfoEntity> successResponse = ApiResponse.success(account);

            return ResponseEntity.ok(successResponse);
        } catch (Exception e){
            return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }
}

package com.huyhuynh.busserver.controller.api;

import com.huyhuynh.busserver.entity.BankInfoEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.services.BankInfoService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.apiPrePath+"/vinbusservices")
public class BankInfoController {

    @Autowired
    private BankInfoService bankInfoService;

    @PostMapping("/integration/CreateBankBinInfor")
    public ResponseEntity<ApiResponse<List<BankInfoEntity>>> saveListBankInfo(@RequestBody List<BankInfoEntity> bankInfoEntityList) {
        try {
            List<BankInfoEntity> datas = bankInfoService.saveList(bankInfoEntityList);
            return ResponseEntity.ok(ApiResponse.success(datas));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }

    @GetMapping("/integration/GetBankBinInfor")
    public ResponseEntity<ApiResponse<List<BankInfoEntity>>> getBankInfo(@RequestHeader("TOKEN") String token, @RequestHeader("SYSTEM_TYPE") String type) {
        try {
            List<BankInfoEntity> datas = bankInfoService.findAll();
            return ResponseEntity.ok(ApiResponse.success(datas));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }
}

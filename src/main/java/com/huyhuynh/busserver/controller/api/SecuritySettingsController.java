package com.huyhuynh.busserver.controller.api;

import com.huyhuynh.busserver.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.apiPrePath+"/vinbusservices")
public class SecuritySettingsController {

    @GetMapping("/integration/JWE/GetPublicKey")
    public ResponseEntity<String> getPublicKey(@RequestHeader("TOKEN") String token, @RequestHeader("SYSTEM_TYPE") String type){
        return ResponseEntity.ok("EmptyKey");
    }
}

package com.huyhuynh.busserver.controller.pos;

import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.posApiPrePath)
public class CardControler {

    @GetMapping("/monthcard/getwhitelist/{routeID}")
    public ResponseEntity<ApiResponse<String>> getAllWhiteListMonthCard(@PathVariable String routeID){
        return ResponseEntity.ok(ApiResponse.success(""));
    }

    @GetMapping("/blacklistcard/getblacklistfile")
    public ResponseEntity<ApiResponse<String>> getAllBlackATM(){
        return ResponseEntity.ok(ApiResponse.success(""));
    }

    @GetMapping("/blacklistcard/getblacklistfileadd")
    public ResponseEntity<ApiResponse<String>> downloadTodayBlackATM(){
        return ResponseEntity.ok(ApiResponse.success(""));
    }
}

package com.huyhuynh.busserver.controller.pos;

import com.huyhuynh.busserver.entity.DataLogEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.model.DataLogRequest;
import com.huyhuynh.busserver.services.DataLogService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constants.posApiPrePath+"/syncdatalog")
public class SyncDataLogController {

    @Autowired
    private DataLogService dataLogService;

    @PostMapping("/insert")
    public ResponseEntity<ApiResponse<DataLogEntity>> insertSyncDataLog(@RequestBody DataLogRequest dataLogEntity) {
        try {
            DataLogEntity log = dataLogService.save(dataLogEntity.toEntity());
            return ResponseEntity.ok(ApiResponse.success(log));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }
}

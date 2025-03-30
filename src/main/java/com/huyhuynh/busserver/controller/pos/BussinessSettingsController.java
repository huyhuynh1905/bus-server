package com.huyhuynh.busserver.controller.pos;

import com.huyhuynh.busserver.entity.PosParaEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.services.PosParaService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.posApiPrePath+"/businesssetting")
public class BussinessSettingsController {
    @Autowired
    private PosParaService posParaService;

    @PostMapping("/insert-list-pos-para")
    public ResponseEntity<ApiResponse<List<PosParaEntity>>> insertList(@RequestBody List<PosParaEntity> posParaEntities) {
        ApiResponse<List<PosParaEntity>> apiResponse = new ApiResponse<>();
        try {
            List<PosParaEntity> list = posParaService.insertAll(posParaEntities);
            apiResponse.setData(list);
            return ResponseEntity.ok(apiResponse);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(ApiResponse.error(List.of(e.getMessage())));
        }
    }

    @GetMapping("/pos-para")
    public ResponseEntity<ApiResponse<List<PosParaEntity>>> getPosParaList() {
        try {
            List<PosParaEntity> posParaEntities = posParaService.getAll();
            return ResponseEntity.ok(ApiResponse.success(posParaEntities));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(ApiResponse.error(List.of(e.getMessage())));
        }
    }
}

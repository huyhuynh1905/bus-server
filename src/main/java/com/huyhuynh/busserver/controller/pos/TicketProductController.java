package com.huyhuynh.busserver.controller.pos;

import com.huyhuynh.busserver.entity.RouteEntity;
import com.huyhuynh.busserver.entity.TicketProductEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.model.TicketProductResponseModel;
import com.huyhuynh.busserver.services.TicketProductService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.posApiPrePath+"/ticketproduct")
public class TicketProductController {

    @Autowired
    private TicketProductService ticketProductService;

    @PostMapping("/insert-list")
    public ResponseEntity<ApiResponse<TicketProductResponseModel>> insertTicketProducts(@RequestBody List<TicketProductEntity> entities){
        try {
            List<TicketProductEntity> list = ticketProductService.insertAll(entities);
            TicketProductResponseModel ticketProductResponseModel = new TicketProductResponseModel();
            ticketProductResponseModel.setTicketProducts(list);
            return ResponseEntity.ok(ApiResponse.success(ticketProductResponseModel));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }


    @PostMapping("getbyrouteid")
    public ResponseEntity<ApiResponse<TicketProductResponseModel>> getByRouteId(@RequestParam Integer routeId){
        try {
            List<TicketProductEntity> list = ticketProductService.findAllByRouteId(routeId);
            TicketProductResponseModel ticketProductResponseModel = new TicketProductResponseModel();
            ticketProductResponseModel.setTicketProducts(list);
            return ResponseEntity.ok(ApiResponse.success(ticketProductResponseModel));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }

}

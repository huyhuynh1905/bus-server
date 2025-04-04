package com.huyhuynh.busserver.controller.pos;

import com.huyhuynh.busserver.entity.TicketOrderEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.services.TicketOrderService;
import com.huyhuynh.busserver.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.posApiPrePath+"/ticket-order")
public class TicketOrderController {

    @Autowired
    private TicketOrderService ticketOrderService;


    @PostMapping("/insert")
    public ResponseEntity<ApiResponse<List<TicketOrderEntity>>> saveTicketOrders(@RequestBody List<TicketOrderEntity> ticketOrderEntities){
        List<TicketOrderEntity> resData = ticketOrderService.saveAll(ticketOrderEntities);
        ApiResponse.success(resData);
        return ResponseEntity.ok(ApiResponse.success(resData));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<TicketOrderEntity>>> getAllTicketOrders(){
        return ResponseEntity.ok(ApiResponse.success(ticketOrderService.findAll()));
    }

    @PostMapping("/get-by-scheduler-id")
    public ResponseEntity<ApiResponse<List<TicketOrderEntity>>> getTicketOrdersBySchedulerId(@RequestParam("schedulerId") Integer schedulerId){
        List<TicketOrderEntity> resData = ticketOrderService.findByScheduleId(schedulerId);
        return ResponseEntity.ok(ApiResponse.success(resData));
    }

}

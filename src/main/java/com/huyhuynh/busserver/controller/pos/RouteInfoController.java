package com.huyhuynh.busserver.controller.pos;

import com.huyhuynh.busserver.entity.BusStopEntity;
import com.huyhuynh.busserver.entity.RouteEntity;
import com.huyhuynh.busserver.entity.SummarySchedulerEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.model.RouteInfoResponseModel;
import com.huyhuynh.busserver.model.RouteRequestModel;
import com.huyhuynh.busserver.services.BusStopServices;
import com.huyhuynh.busserver.services.RouteServices;
import com.huyhuynh.busserver.services.SummaryScheduleServices;
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
@RequestMapping(Constants.posApiPrePath + "/mroute")
public class RouteInfoController {

    @Autowired
    private SummaryScheduleServices summaryScheduleServices;

    @Autowired
    private RouteServices routeServices;

    @Autowired
    private BusStopServices busStopServices;

    @PostMapping("/getbyid")
    public ResponseEntity<ApiResponse<RouteInfoResponseModel>> getById(@RequestBody RouteRequestModel request) {
        try {
            RouteInfoResponseModel routeInfoResponseModel = new RouteInfoResponseModel();
            List<BusStopEntity> busStopEntities = busStopServices.getBusStopByRouteId(request.getRouteId());
            List<SummarySchedulerEntity> summarySchedulerEntities = summaryScheduleServices.getAllSummarySchedulesByRouteIdAndNode(request.getRouteId(), request.getNode());
            RouteEntity routeEntity = routeServices.getRouteById(request.getRouteId().longValue());
            routeInfoResponseModel.setMRoute(routeEntity);
            routeInfoResponseModel.setMBusStops(busStopEntities);
            routeInfoResponseModel.setSummarySchedules(summarySchedulerEntities);
            return ResponseEntity.ok(ApiResponse.success(routeInfoResponseModel));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }

    @PostMapping("/create-route")
    public ResponseEntity<ApiResponse<RouteEntity>> create(@RequestBody RouteEntity request) {
        try {
            RouteEntity routeEntity = routeServices.createRoute(request);
            return ResponseEntity.ok(ApiResponse.success(routeEntity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }

    @PostMapping("/create-bus-stops")
    public ResponseEntity<ApiResponse<List<BusStopEntity>>> create(@RequestBody List<BusStopEntity> request) {
        try {
            List<BusStopEntity> list = busStopServices.createBusStop(request);
            return ResponseEntity.ok(ApiResponse.success(list));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }

    @PostMapping("/create-summary")
    public ResponseEntity<ApiResponse<SummarySchedulerEntity>> createSummary(@RequestBody SummarySchedulerEntity request) {
        try {
            SummarySchedulerEntity summarySchedulerEntity = summaryScheduleServices.createSummarySchedule(request);
            return ResponseEntity.ok(ApiResponse.success(summarySchedulerEntity));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }


}

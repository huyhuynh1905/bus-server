package com.huyhuynh.busserver.controller.pos;

import com.huyhuynh.busserver.entity.ShiftSchedulerEntity;
import com.huyhuynh.busserver.model.ApiResponse;
import com.huyhuynh.busserver.model.ShiftScheduleRequest;
import com.huyhuynh.busserver.services.ShiftScheduleService;
import com.huyhuynh.busserver.utils.Constants;
import com.huyhuynh.busserver.utils.DateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.posApiPrePath + "/shiftscheduler")
public class ShiftScheduleController {

    @Autowired
    private ShiftScheduleService shiftScheduleService;

    @PostMapping("/inserts-today")
    public ResponseEntity<ApiResponse<List<ShiftSchedulerEntity>>> insertsForToday(@RequestBody List<ShiftSchedulerEntity> list) {
        try {
            for (int i = 0; i < list.size(); i++) {
                String timeDate = DateTimeUtils.getCurrentDateyyMMdd();
                list.get(i).setScheduleId(list.get(i).getScheduleId()+timeDate);
                String timeSchedulerToday = DateTimeUtils.updateToCurrentDate(list.get(i).getScheduleTime());
                list.get(i).setScheduleTime(timeSchedulerToday);
                list.get(i).setId(null); //để id tự tăng
            }
            boolean success = shiftScheduleService.saveListScheduler(list);
            if (success) {
                return ResponseEntity.ok(ApiResponse.success(list));
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of("Không thể thêm danh sách, vui lòng kiểm tra lại")));
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }

    @PostMapping("/getbydate")
    public ResponseEntity<ApiResponse<List<ShiftSchedulerEntity>>> getByDate(@RequestBody ShiftScheduleRequest request) {
        try {
            String timeDate = DateTimeUtils.formatDateString(request.getScheduleTime(), DateTimeUtils.DATE_TIME_DB_FORMATTER, DateTimeUtils.DATE_FORMATTER);
            List<ShiftSchedulerEntity> list = shiftScheduleService.findAllByTimeAndSallerId(request.getSellerIdCard(), timeDate);
            ApiResponse<List<ShiftSchedulerEntity>> successResponse = ApiResponse.success(list);
            return ResponseEntity.ok(successResponse);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }

    @DeleteMapping("/remove-all")
    public ResponseEntity<ApiResponse<String>> removeAll() {
        try {
            shiftScheduleService.deleteListAll();
            return ResponseEntity.ok(ApiResponse.success("Xoá Thành Công"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ApiResponse.error(List.of(e.getMessage())));
        }
    }
}

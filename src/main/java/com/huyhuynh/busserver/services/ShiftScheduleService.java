package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.ShiftSchedulerEntity;
import com.huyhuynh.busserver.repository.ShiftSchduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShiftScheduleService {

    @Autowired
    private ShiftSchduleRepository shiftSchduleRepository;

    public List<ShiftSchedulerEntity> findAllByTimeAndSallerId(String sellerIdCard, String scheduleTime) {

        return shiftSchduleRepository.findAllBySellerIdCardAndScheduleTimeContains(sellerIdCard,scheduleTime);
    }

    public boolean saveListScheduler(List<ShiftSchedulerEntity> entities){
        try {
            shiftSchduleRepository.saveAll(entities);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void deleteListAll(){
        shiftSchduleRepository.deleteAll();
    }
}
package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.ShiftSchedulerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShiftSchduleRepository extends JpaRepository<ShiftSchedulerEntity, Long> {
    List<ShiftSchedulerEntity> findAllBySellerIdCardAndScheduleTimeContains(String sellerIdCard, String scheduleTime);
}

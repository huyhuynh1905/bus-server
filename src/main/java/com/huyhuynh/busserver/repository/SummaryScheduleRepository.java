package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.SummarySchedulerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummaryScheduleRepository extends JpaRepository<SummarySchedulerEntity,Long> {
    List<SummarySchedulerEntity> findAllByRouteIdAndNode(Integer routeId, String node);
}

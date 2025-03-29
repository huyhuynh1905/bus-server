package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.SummarySchedulerEntity;
import com.huyhuynh.busserver.repository.SummaryScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SummaryScheduleServices {
    @Autowired
    private SummaryScheduleRepository summaryScheduleRepository;

    public List<SummarySchedulerEntity> getAllSummarySchedulesByRouteIdAndNode(Integer routeId, String node) {
        return  summaryScheduleRepository.findAllByRouteIdAndNode(routeId, node);
    }

    public SummarySchedulerEntity createSummarySchedule(SummarySchedulerEntity summaryScheduleEntity) {
        return summaryScheduleRepository.save(summaryScheduleEntity);
    }
}

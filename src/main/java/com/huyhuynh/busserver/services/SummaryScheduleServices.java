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
        return  summaryScheduleRepository.findLatestTicketsByRouteAndNode(routeId, node);
    }

    public List<SummarySchedulerEntity> createListSummarySchedule(List<SummarySchedulerEntity> list) {
        return  summaryScheduleRepository.saveAll(list);
    }

    public SummarySchedulerEntity createSummarySchedule(SummarySchedulerEntity summaryScheduleEntity) {
        return summaryScheduleRepository.save(summaryScheduleEntity);
    }

    public SummarySchedulerEntity getLastSummaryScheduleByRouteIdAndNode(Integer routeId, String node) {
        List<SummarySchedulerEntity> list =  summaryScheduleRepository.findAllByRouteIdAndNode(routeId, node);
        list.sort(SummarySchedulerEntity::compareByScheduleTime);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }
}

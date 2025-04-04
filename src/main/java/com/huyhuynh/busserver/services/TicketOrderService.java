package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.TicketOrderEntity;
import com.huyhuynh.busserver.repository.TicketOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketOrderService {

    @Autowired
    private TicketOrderRepository ticketOrderRepository;

    public List<TicketOrderEntity> saveAll(List<TicketOrderEntity> ticketOrderEntities) {
        return ticketOrderRepository.saveAll(ticketOrderEntities);
    }

    public List<TicketOrderEntity> findAll() {
        return ticketOrderRepository.findAll();
    }

    public List<TicketOrderEntity> findByScheduleId(Integer scheduleId) {
        return ticketOrderRepository.findAllBySchedulerId(scheduleId);
    }
}

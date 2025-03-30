package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.TicketProductEntity;
import com.huyhuynh.busserver.repository.TicketProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketProductService {
    @Autowired
    private TicketProductRepository ticketProductRepository;

    public List<TicketProductEntity> insertAll(List<TicketProductEntity> ticketProductEntities) {
        return ticketProductRepository.saveAll(ticketProductEntities);
    }

    public List<TicketProductEntity> findAllByRouteId(Integer routeId) {
        return ticketProductRepository.findByRouteId(routeId);
    }
}

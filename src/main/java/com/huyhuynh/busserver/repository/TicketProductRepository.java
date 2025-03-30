package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.TicketProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketProductRepository extends JpaRepository<TicketProductEntity,Long> {
    List<TicketProductEntity> findByRouteId(Integer routeId);
}

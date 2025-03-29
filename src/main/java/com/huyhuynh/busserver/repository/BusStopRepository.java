package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.BusStopEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusStopRepository extends JpaRepository<BusStopEntity, Long> {
    List<BusStopEntity> findAllByRouteId(Integer routeId);
}

package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<RouteEntity, Long> {
}

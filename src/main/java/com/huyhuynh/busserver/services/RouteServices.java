package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.RouteEntity;
import com.huyhuynh.busserver.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteServices {
    @Autowired
    private RouteRepository routeRepository;

    public List<RouteEntity> getAllRoutes() {
        return  routeRepository.findAll();
    }

    public RouteEntity getRouteById(Long id) {
        return routeRepository.findById(id).orElse(null);
    }

    public RouteEntity createRoute(RouteEntity routeEntity) {
        return routeRepository.save(routeEntity);
    }
}

package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.BusStopEntity;
import com.huyhuynh.busserver.repository.BusStopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusStopServices {

    @Autowired
    private BusStopRepository busStopRepository;

    public List<BusStopEntity> getBusStopByRouteId(int routeId) {
        return busStopRepository.findAllByRouteId(routeId);
    }

    public List<BusStopEntity> createBusStop(List<BusStopEntity> list) {
        return busStopRepository.saveAll(list);
    }

}

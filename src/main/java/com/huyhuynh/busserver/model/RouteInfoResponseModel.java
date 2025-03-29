package com.huyhuynh.busserver.model;

import com.huyhuynh.busserver.entity.BusStopEntity;
import com.huyhuynh.busserver.entity.RouteEntity;
import com.huyhuynh.busserver.entity.SummarySchedulerEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class RouteInfoResponseModel {
    private RouteEntity mRoute;
    private List<BusStopEntity> mBusStops;
    private List<SummarySchedulerEntity> summarySchedules;
}
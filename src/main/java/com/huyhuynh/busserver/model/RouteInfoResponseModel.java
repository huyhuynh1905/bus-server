package com.huyhuynh.busserver.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huyhuynh.busserver.entity.BusStopEntity;
import com.huyhuynh.busserver.entity.RouteEntity;
import com.huyhuynh.busserver.entity.SummarySchedulerEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class RouteInfoResponseModel {
    @JsonProperty("mRoute")
    private RouteEntity mRoute;
    @JsonProperty("mBusStops")
    private List<BusStopEntity> mBusStops;
    @JsonProperty("summarySchedules")
    private List<SummarySchedulerEntity> summarySchedules;
}
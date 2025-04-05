package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.SummarySchedulerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SummaryScheduleRepository extends JpaRepository<SummarySchedulerEntity,Long> {
    List<SummarySchedulerEntity> findAllByRouteIdAndNode(Integer routeId, String node);


    @Query("SELECT t FROM SummarySchedulerEntity t WHERE t.scheduleTime = (SELECT MAX(t2.scheduleTime) FROM SummarySchedulerEntity t2 WHERE t2.ticketId = t.ticketId) AND t.routeId = :routeId AND t.node = :node")
    List<SummarySchedulerEntity> findLatestTicketsByRouteAndNode(@Param("routeId") int routeId, @Param("node") String node);

}

package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.DataLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataLogRepository extends JpaRepository<DataLogEntity,Long> {

}

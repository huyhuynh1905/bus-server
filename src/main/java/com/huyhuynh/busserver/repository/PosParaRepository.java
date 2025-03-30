package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.PosParaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PosParaRepository extends JpaRepository<PosParaEntity, Long> {
}

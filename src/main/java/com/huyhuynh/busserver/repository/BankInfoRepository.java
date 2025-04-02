package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.BankInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankInfoRepository extends JpaRepository<BankInfoEntity,Long> {
}

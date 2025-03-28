package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.CompanyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyInfoRepository extends JpaRepository<CompanyInfoEntity, Long> {
    CompanyInfoEntity findByIdIs(Long id);
}

package com.huyhuynh.busserver.repository;

import com.huyhuynh.busserver.entity.AccountInfoEntity;
import com.huyhuynh.busserver.entity.CompanyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountInfoRepository extends JpaRepository<AccountInfoEntity, Long> {
    AccountInfoEntity findByIdIs(Long id);
    AccountInfoEntity findByUsername(String username);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}

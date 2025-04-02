package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.BankInfoEntity;
import com.huyhuynh.busserver.repository.BankInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankInfoService {

    @Autowired
    private BankInfoRepository bankInfoRepository;

    public List<BankInfoEntity> saveList(List<BankInfoEntity> bankInfoEntities) {
        return bankInfoRepository.saveAll(bankInfoEntities);
    }

    public List<BankInfoEntity> findAll() {
        return bankInfoRepository.findAll();
    }
}

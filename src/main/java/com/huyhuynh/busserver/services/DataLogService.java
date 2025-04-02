package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.DataLogEntity;
import com.huyhuynh.busserver.repository.DataLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DataLogService {

    @Autowired
    private DataLogRepository dataLogRepository;

    public DataLogEntity save(DataLogEntity dataLogEntity) {
        return dataLogRepository.save(dataLogEntity);
    }
}

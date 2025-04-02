package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.PosParaEntity;
import com.huyhuynh.busserver.repository.PosParaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PosParaService {
    @Autowired
    private PosParaRepository posParaRepository;

    public List<PosParaEntity> insertAll(List<PosParaEntity> posParaEntities) {
        return posParaRepository.saveAll(posParaEntities);
    }

    public List<PosParaEntity> getAll() {
        return posParaRepository.findAll();
    }

    public List<PosParaEntity> getAllBySettingType(String settingType) {
        return posParaRepository.findAllBySettingType(settingType);
    }
}

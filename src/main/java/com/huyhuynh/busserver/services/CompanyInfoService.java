package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.CompanyInfoEntity;
import com.huyhuynh.busserver.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoService {

    private CompanyInfoRepository companyInfoRepository;

    public CompanyInfoService(){

    }

    @Autowired
    public CompanyInfoService(CompanyInfoRepository companyInfoRepository) {
        this.companyInfoRepository = companyInfoRepository;
    }

    public CompanyInfoEntity createCompany(CompanyInfoEntity company) {

        return companyInfoRepository.save(company);
    }

    public CompanyInfoEntity getById(Long id) {
        return companyInfoRepository.findByIdIs(id);
    }


}
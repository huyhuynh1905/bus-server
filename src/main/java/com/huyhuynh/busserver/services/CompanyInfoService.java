package com.huyhuynh.busserver.services;
import com.huyhuynh.busserver.entity.CompanyInfoEntity;
import com.huyhuynh.busserver.repository.CompanyInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyInfoService {

    @Autowired(required = false)
    private CompanyInfoRepository companyInfoRepository;

    public CompanyInfoService() {
    }

    public CompanyInfoEntity createCompany(String name, String code, String address, String phone, String email, String website) {
        CompanyInfoEntity company = new CompanyInfoEntity();
        company.setCompanyName(name);
        company.setCompanyCode(code);
        company.setAddress(address);
        company.setPhone(phone);
        company.setEmail(email);
        company.setWebsite(website);

        return companyInfoRepository.save(company);
    }
}
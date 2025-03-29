package com.huyhuynh.busserver.mapper;

import com.huyhuynh.busserver.dto.AccountInfoDTO;
import com.huyhuynh.busserver.entity.AccountInfoEntity;
import org.springframework.stereotype.Component;

@Component
public class AccountInfoMapper {

    public AccountInfoDTO toDTO(AccountInfoEntity account) {
        if (account == null) {
            return null;
        }

        AccountInfoDTO dto = new AccountInfoDTO();
        dto.setId(account.getId());
        dto.setUsername(account.getUsername());
        dto.setPassword(account.getPassword());
        dto.setRole(account.getRole());
        dto.setFullName(account.getFullName());
        dto.setPhone(account.getPhone());
        dto.setEmail(account.getEmail());
        dto.setFirstName(account.getFirstName());
        dto.setLastName(account.getLastName());
        dto.setJobTitle(account.getJobTitle());
        dto.setFirstLogin(account.getFirstLogin());
        dto.setRouteId(account.getRouteId());
        dto.setIdCard(account.getIdCard());
        dto.setActived(account.getActived());
        dto.setLocked(account.getLocked());

        // Chuyển đổi companyInfo thành companyId
        if (account.getCompanyInfo() != null) {
            dto.setCompanyId(account.getCompanyInfo().getId());
        }

        return dto;
    }

    public AccountInfoEntity toEntity(AccountInfoDTO dto) {
        if (dto == null) {
            return null;
        }

        AccountInfoEntity entity = new AccountInfoEntity();
        entity.setId(dto.getId());
        entity.setUsername(dto.getUsername());
        entity.setPassword(dto.getPassword());
        entity.setRole(dto.getRole());
        entity.setFullName(dto.getFullName());
        entity.setPhone(dto.getPhone());
        entity.setEmail(dto.getEmail());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setJobTitle(dto.getJobTitle());
        entity.setFirstLogin(dto.getFirstLogin());
        entity.setRouteId(dto.getRouteId());
        entity.setIdCard(dto.getIdCard());
        entity.setActived(dto.getActived());
        entity.setLocked(dto.getLocked());

        return entity;
    }
}

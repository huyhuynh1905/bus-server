package com.huyhuynh.busserver.services;

import com.huyhuynh.busserver.entity.AccountInfoEntity;
import com.huyhuynh.busserver.repository.AccountInfoRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountInfoService implements UserDetailsService {

    private AccountInfoRepository accountInfoRepository;
    private PasswordEncoder passwordEncoder;

    public AccountInfoService(){

    }

    public AccountInfoService(AccountInfoRepository accountInfoRepository, PasswordEncoder passwordEncoder) {
        this.accountInfoRepository = accountInfoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AccountInfoEntity user = accountInfoRepository.findByUsername(username);
//                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));

        return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
    }

    public AccountInfoEntity registerUser(AccountInfoEntity accountInfoEntity) {
        accountInfoEntity.setPassword(passwordEncoder.encode(accountInfoEntity.getPassword()));
        return accountInfoRepository.save(accountInfoEntity);
    }

    public List<AccountInfoEntity> getAllAccounts() {
        return accountInfoRepository.findAll();
    }

    public Optional<AccountInfoEntity> getAccountById(Long id) {
        return accountInfoRepository.findById(id);
    }

    public AccountInfoEntity createAccount(AccountInfoEntity account) {
        account.setPassword(passwordEncoder.encode(account.getPassword())); // Mã hóa mật khẩu
        return accountInfoRepository.save(account);
    }

    public AccountInfoEntity updateAccount(Long id, AccountInfoEntity newAccountInfo) {
        return accountInfoRepository.findById(id).map(account -> {
            account.setUsername(newAccountInfo.getUsername());
            account.setPassword(passwordEncoder.encode(newAccountInfo.getPassword()));
            return accountInfoRepository.save(account);
        }).orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    public void deleteAccount(Long id) {
        accountInfoRepository.deleteById(id);
    }
}
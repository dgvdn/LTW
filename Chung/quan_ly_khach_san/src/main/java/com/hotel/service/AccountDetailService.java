package com.hotel.service;

import com.hotel.model.Account;
import com.hotel.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AccountDetailService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email);
        if(account==null){
                throw new UsernameNotFoundException("Login Fail");
        }
        return new AccountDetail(account);
    }
}

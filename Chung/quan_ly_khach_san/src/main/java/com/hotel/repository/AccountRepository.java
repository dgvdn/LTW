package com.hotel.repository;

import com.hotel.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
   Account findByEmail(String email);
}

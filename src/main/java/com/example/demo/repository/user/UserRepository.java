package com.example.demo.repository.user;

import com.example.demo.Entity.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, String> {

    Account findByUserId(String userId);
}

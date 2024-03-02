package com.example.demo.repository;

import com.example.demo.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Account, String> {

    Account findByUserId(String userId);
}

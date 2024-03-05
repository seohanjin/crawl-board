package com.example.demo.repository.user;

import com.example.demo.Entity.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Account, Long> {

    Account findByUserId(String userId);

}

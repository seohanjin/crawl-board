package com.example.demo.service.user;

import com.example.demo.Entity.user.Account;
import com.example.demo.dto.user.AccountDto;
import com.example.demo.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Account findUserInfo(Long id) {
        Account account = userRepository.findById(id).orElse(null);
        return account;
    }

    public boolean duplChkAccount(AccountDto accountDto) {
        Account findUser = userRepository.findByUserId(accountDto.getUserId());
        if (findUser != null) {
            return true;
        }
        return false;
    }

    @Transactional
    public void createUser(Account account) {
        userRepository.save(account);
    }
}

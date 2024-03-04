package com.example.demo.restcontroller.user;

import com.example.demo.dto.user.AccountDto;
import com.example.demo.service.user.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountRestController {

    private final AccountService accountService;

    @GetMapping("/list")
    public Map<String, Object> getAccountList(AccountDto accountDto) {

        Map<String, Object> result = accountService.getAccountList(accountDto);

        return result;
    }
}

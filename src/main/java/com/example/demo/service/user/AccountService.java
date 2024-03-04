package com.example.demo.service.user;

import com.example.demo.dto.user.AccountDto;
import com.example.demo.mapper.user.AccountMapper;
import com.example.demo.service.common.BoardService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.core.util.PasswordDecryptor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final BoardService boardService;
    private final AccountMapper accountMapper;

    public Map<String, Object> getAccountList(AccountDto accountDto) {

        int offset = (accountDto.getPage() - 1) * 10;
        accountDto.setOffset(offset);

        int accountTotCnt = accountMapper.getAccountTotCnt();
        List<AccountDto> accountList = accountMapper.getAccountList(accountDto);

        Map<String, Object> accountInfo = boardService.getBoardInfo(accountTotCnt, accountDto.getPage());

        accountInfo.put("resultList", accountList);

        return accountInfo;
    }
}

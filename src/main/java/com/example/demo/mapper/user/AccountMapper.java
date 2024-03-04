package com.example.demo.mapper.user;

import com.example.demo.dto.user.AccountDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    int getAccountTotCnt(AccountDto accountDto);
    List<AccountDto> getAccountList(AccountDto accountDto);
}

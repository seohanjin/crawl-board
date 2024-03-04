package com.example.demo.mapper.user;

import com.example.demo.dto.user.AccountDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {

    List<AccountDto> getAccountList(AccountDto accountDto);
    int getAccountTotCnt();
}

package com.example.demo.dto.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class AccountDto {

    @NotEmpty(message = "아이디는 필수값 입니다.")
    private String userId;
    @NotEmpty(message = "비밀번호는 필수값 입니다.")
    private String userPw;
    private String role;
    private String agency;

    private int page;
    private int offset;
    private int totCnt;
}

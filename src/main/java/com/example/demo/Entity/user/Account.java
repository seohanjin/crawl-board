package com.example.demo.Entity.user;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String userId;
    private String userPw;
    private String agency;
    private String role;
    private String remark;

    @Builder
    public Account(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
        this.role   = "ROLE_USER";
    }


}

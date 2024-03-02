package com.example.demo.Entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account{

    @Id
    private String userId;
    private String userPw;
    private String role;

    @Builder
    public Account(String userId, String userPw) {
        this.userId = userId;
        this.userPw = userPw;
        this.role   = "ROLE_USER";
    }


}

package com.example.demo.controller.user;

import com.example.demo.Entity.user.Account;
import com.example.demo.dto.user.AccountDto;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class RegisterController {

    private final UserService userService;
//    private final PasswordEncoder passwordEncoder;

    @GetMapping("/register")
    public String createUser(Model model) {

        model.addAttribute("accountForm", new AccountDto());
        return "account/register";
    }

    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute("accountForm") AccountDto accountDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
             return "account/register";
        };

        boolean chk = userService.duplChkAccount(accountDto);
        if (chk) {
            bindingResult.addError(new FieldError("accountForm", "userId", "중복된 아이디 입니다."));
            return "account/register";
        }

        Account account = Account.builder()
                .userId(accountDto.getUserId())
//                .userPw(passwordEncoder.encode(accountDto.getUserPw()))
                .userPw(accountDto.getUserPw())
                .build();

        userService.createUser(account);

        return "redirect:/";
    }
}

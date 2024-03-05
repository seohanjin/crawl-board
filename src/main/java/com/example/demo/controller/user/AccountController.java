package com.example.demo.controller.user;

import com.example.demo.Entity.user.Account;
import com.example.demo.dto.user.AccountDto;
import com.example.demo.repository.user.UserRepository;
import com.example.demo.service.user.AccountService;
import com.example.demo.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final UserService userService;

    @GetMapping("/list")
    public String getAccountList() {
        return "account/account_list";
    }

    @GetMapping("/profile")
    public String getAccountSelf(Model model) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Account account = (Account) authentication.getPrincipal();

        Account findUser = userService.findUserInfo(account.getId());
        String roleNm = "";
        String role = findUser.getRole();
        if ("ROLE_USER".equals(role)) {
            roleNm = "유저";
        } else if("ROLE_MANAGER".equals(role)) {
            roleNm = "매니저";
        } else if("ROLE_ADMIN".equals(role)) {
            roleNm = "관리자";
        }

        model.addAttribute("id", findUser.getId());
        model.addAttribute("userId", findUser.getUserId());
        model.addAttribute("userPw", findUser.getUserPw());
        model.addAttribute("roleNm", roleNm);
        model.addAttribute("remark", findUser.getRemark());
        model.addAttribute("agency", findUser.getAgency());

        return "account/profile";
    }


    @GetMapping("/detail/{id}")
    public String getAccountDetail(@PathVariable(value = "id") Long id, Model model) {

        model.addAttribute("id", id);

        return "account/account_detail";
    }
}

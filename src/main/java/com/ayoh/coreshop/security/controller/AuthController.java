package com.ayoh.coreshop.security.controller;

import com.ayoh.coreshop.dto.member.MemberLoginRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping(path = "/login")
    public String goLoginPage(Model model) {
        model.addAttribute("memberLoginRequest", new MemberLoginRequest(null, null));
        return "pages/auth/login";
    }

    @GetMapping(path = "/login/error")
    public String loginError(Model model) {
        model.addAttribute("loginErrorMessage", "아이디 또는 비밀번호를 확인해주세요");
        return "pages/auth/login";
    }

    @GetMapping(path = "/logout")
    public String goLogoutPage() {
        return "pages/auth/logout";
    }

}

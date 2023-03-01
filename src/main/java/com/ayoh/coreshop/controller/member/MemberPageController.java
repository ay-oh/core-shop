package com.ayoh.coreshop.controller.member;

import com.ayoh.coreshop.dto.MemberLoginRequest;
import com.ayoh.coreshop.dto.MemberSignUpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberPageController {

    @GetMapping(path = "/signup")
    public String goSignUpFormPage(Model model) {
        // thymeleaf 뷰 템플릿 엔진에서 th:object 와 th:field 문법을 사용하기 위해 모델에 빈 객체 설정
        model.addAttribute("memberSignUpRequest", new MemberSignUpRequest(null, null, null, null));
        return "pages/auth/signup";
    }

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

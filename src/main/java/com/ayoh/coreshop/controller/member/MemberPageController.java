package com.ayoh.coreshop.controller.member;

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

}

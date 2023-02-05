package com.ayoh.coreshop.controller;

import com.ayoh.coreshop.dto.MemberSignUpRequest;
import com.ayoh.coreshop.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping(path = "/signup")
    public String goSignUpFormPage(Model model) {
        model.addAttribute("memberSignUpRequest", new MemberSignUpRequest(null, null, null, null));
        return "pages/members/signup";
    }

    @PostMapping(path = "/signup")
    public String doSignUp(final MemberSignUpRequest memberRequest) {
        memberService.signUp(memberRequest);
        return "redirect:/";
    }

}

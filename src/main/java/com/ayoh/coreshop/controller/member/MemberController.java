package com.ayoh.coreshop.controller.member;

import com.ayoh.coreshop.dto.MemberSignUpRequest;
import com.ayoh.coreshop.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 회원 관련 요청을 다루는 컨트롤러 클래스입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller
@RequiredArgsConstructor
public class MemberController {

    // QUESTION: 왜 final 예약어를 붙이면 서비스 컴포넌트가 주입이 될까?
    private final MemberService memberService;

    @PostMapping(path = "/signup")
    public String doSignUp(MemberSignUpRequest memberRequest) {
        memberService.signUp(memberRequest);
        return "redirect:/";
    }

}

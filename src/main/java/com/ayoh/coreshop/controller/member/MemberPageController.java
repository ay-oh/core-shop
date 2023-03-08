package com.ayoh.coreshop.controller.member;

import com.ayoh.coreshop.dto.member.MemberSignUpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 회원 관련 페이지 요청을 다루는 컨트롤러 클래스입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Slf4j
@Controller
public class MemberPageController {

    @GetMapping(path = "/signup")
    public String goSignUpFormPage(@RequestParam(name = "success") boolean isSuccess, Model model) {
        log.info("isSuccess: {}", isSuccess);

        // thymeleaf 뷰 템플릿 엔진에서 th:object 와 th:field 문법을 사용하기 위해 모델에 빈 객체 설정
        model.addAttribute("memberSignUpRequest", new MemberSignUpRequest(null, null, null, null));
        return "pages/auth/signup";
    }

}

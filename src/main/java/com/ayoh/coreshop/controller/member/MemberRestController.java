package com.ayoh.coreshop.controller.member;

import com.ayoh.coreshop.dto.member.MemberSignUpRequest;
import com.ayoh.coreshop.entity.member.Member;
import com.ayoh.coreshop.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequiredArgsConstructor
public class MemberRestController {

    private final MemberService memberService;

    @PostMapping(path = "/api/signup")
    public ResponseEntity<Member> callSignUpApi(@RequestBody MemberSignUpRequest memberRequest) {
        Member member = memberService.signUp(memberRequest);
        return ResponseEntity.created(URI.create("/signup?success")).body(member);
    }

}

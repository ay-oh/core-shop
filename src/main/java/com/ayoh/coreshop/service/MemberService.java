package com.ayoh.coreshop.service;

import com.ayoh.coreshop.dto.MemberSignUpRequest;
import com.ayoh.coreshop.entity.member.Member;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberService {

    static Member toEntity(MemberSignUpRequest memberRequest, PasswordEncoder passwordEncoder) {
        return Member.newInstance(memberRequest, passwordEncoder);
    }

    Member signUp(MemberSignUpRequest memberRequest);

}

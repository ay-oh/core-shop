package com.ayoh.coreshop.service.member;

import com.ayoh.coreshop.dto.member.MemberSignUpRequest;
import com.ayoh.coreshop.entity.member.Member;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface MemberService extends UserDetailsService {

    static Member toEntity(MemberSignUpRequest memberRequest, PasswordEncoder passwordEncoder) {
        return Member.newInstance(memberRequest, passwordEncoder);
    }

    Member signUp(MemberSignUpRequest memberRequest);

}

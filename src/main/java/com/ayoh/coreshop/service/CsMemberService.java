package com.ayoh.coreshop.service;

import com.ayoh.coreshop.dto.MemberSignUpRequest;
import com.ayoh.coreshop.entity.member.Member;
import com.ayoh.coreshop.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CsMemberService implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public Member signUp(MemberSignUpRequest memberRequest) {
        Member member = MemberService.toEntity(memberRequest, passwordEncoder);
        Optional<Member> optionalMember = memberRepository.findByEmail(member.getEmail());

        if (optionalMember.isPresent()) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }

        return memberRepository.save(member);
    }

    // Check the availability of a member
    // private void validateMemberAvailability(Member member) {
    // }

}

package com.ayoh.coreshop.service;

import com.ayoh.coreshop.entity.member.Member;
import com.ayoh.coreshop.repository.MemberRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    @Transactional
    public Member signUp(Member member) {
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

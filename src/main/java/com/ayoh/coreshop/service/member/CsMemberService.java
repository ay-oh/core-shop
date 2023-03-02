package com.ayoh.coreshop.service.member;

import com.ayoh.coreshop.dto.member.MemberSignUpRequest;
import com.ayoh.coreshop.entity.member.Member;
import com.ayoh.coreshop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

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

    /**
     * 회원 정보를 조회하여 사용자의 정보와 권한을 갖는 {@link UserDetails} 인터페이스를 반환합니다.
     * <p>
     * {@inheritDoc}
     *
     * @param email the email identifying the user whose data is required.
     * @return {@link UserDetails} 인터페이스
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                                        .orElseThrow(() -> new UsernameNotFoundException(email));

        return User.builder()
                   .username(member.getEmail())
                   .password(member.getPassword())
                   .roles(member.getRole().toString())
                   .build();
    }

}

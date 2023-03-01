package com.ayoh.coreshop.security.service;

import com.ayoh.coreshop.entity.member.Role;
import com.ayoh.coreshop.entity.member.Member;
import com.ayoh.coreshop.repository.MemberRepository;
import com.ayoh.coreshop.repository.RoleRepository;
import com.ayoh.coreshop.security.domain.CsUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.ayoh.coreshop.security.util.WebSecurityUtils.USER_NOT_FOUND_MESSAGE;

/**
 * 로그인 폼으로 요청한 아이디와 비밀번호를 검증합니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CsUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final RoleRepository roleRepository;

    /**
     * username 을 통해 사용자 정보를 조회합니다.
     *
     * @param email the username identifying the user whose data is required.
     * @return {@link UserDetails}
     * @throws UsernameNotFoundException 사용자 정보를 찾지 못했을 때 발생하는 예외
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findByEmail(email)
                                        .orElseThrow(() -> new UsernameNotFoundException(USER_NOT_FOUND_MESSAGE));

        List<Role> roles = roleRepository.findRolesByEmail(member.getEmail());

        return new CsUserDetails(member.getEmail(), member.getPassword(), roles);
    }

}

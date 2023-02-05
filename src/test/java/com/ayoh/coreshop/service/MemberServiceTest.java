package com.ayoh.coreshop.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.ayoh.coreshop.dto.MemberSignUpRequest;
import com.ayoh.coreshop.entity.member.Member;
import com.ayoh.coreshop.repository.MemberRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

@ExtendWith(MockitoExtension.class)
class MemberServiceTest {

    @InjectMocks
    CsMemberService memberService;

    @Mock
    MemberRepository memberRepository;

    @Mock
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원가입 테스트")
    void signUp() {
        // given
        MemberSignUpRequest signUpRequest = this.createMemberSignUpRequest();
        Member member = MemberService.toEntity(signUpRequest, passwordEncoder);
        given(memberRepository.findByEmail(anyString())).willReturn(Optional.empty());
        given(memberRepository.save(any(Member.class))).willReturn(member);

        // when
        Member savedMember = memberService.signUp(signUpRequest);

        // then
        assertThat(member.getEmail()).isEqualTo(savedMember.getEmail());
        assertEquals(member.getPassword(), savedMember.getPassword());
        assertEquals(member.getName(), savedMember.getName());
        assertEquals(member.getAddress(), savedMember.getAddress());
    }

    @Test
    void testSignUpAccountAlreadyExistsThenThrowException() {
        // given
        MemberSignUpRequest signUpRequest1 = this.createMemberSignUpRequest();
        Member member1 = MemberService.toEntity(signUpRequest1, passwordEncoder);
        MemberSignUpRequest signUpRequest2 = this.createMemberSignUpRequest();
        given(memberRepository.findByEmail(anyString())).willReturn(Optional.ofNullable(member1));

        // when
        assertThatThrownBy(() -> memberService.signUp(signUpRequest2)).isInstanceOf(IllegalStateException.class);

        // then
        verify(memberRepository, times(1)).findByEmail(anyString());
    }

    private Member createMember() {
        MemberSignUpRequest request = new MemberSignUpRequest();
        request.setEmail("test@gmail.com");
        request.setPassword("{bcrypt}123$");
        request.setName("홍길동");
        request.setAddress("서울특별시 송파구 잠실본동");

        return Member.newInstance(request, passwordEncoder);
    }

    private MemberSignUpRequest createMemberSignUpRequest() {
        MemberSignUpRequest request = new MemberSignUpRequest();
        request.setEmail("test@gmail.com");
        request.setPassword("{bcrypt}123$");
        request.setName("홍길동");
        request.setAddress("서울특별시 송파구 잠실본동");

        return request;
    }

}

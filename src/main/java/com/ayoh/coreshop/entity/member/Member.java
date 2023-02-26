package com.ayoh.coreshop.entity.member;

import com.ayoh.coreshop.dto.MemberSignUpRequest;
import com.ayoh.coreshop.security.constant.Role;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 회원 개체입니다.
 *
 * Javadoc: Java Documentation
 *
 * @version 1.1.0
 * @since 1.0.0
 */
@Table(name = "members")
@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long id;

    @Column(unique = true)
    private String email;

    // NOTE: 테이블 컬럼명과 자바 필드명이 일치하는 경우 @Column 애노테이션 생략 가능
    // @Column
    private String password;

    // NOTE: 가독성을 위해 모두 명시하거나, 애노테이션을 생략하는 방식 중 하나를 택하되 혼용해서 사용하지 말 것
    @Column
    private String name;

    @Column
    private String address;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedDate;

    public static Member newInstance(final MemberSignUpRequest memberRequest, final PasswordEncoder passwordEncoder) {
        Member member = new Member();
        member.setEmail(memberRequest.getEmail());
        member.setName(memberRequest.getName());
        member.setAddress(memberRequest.getAddress());

        // 스프링 시큐리티 구성 클래스에 등록한 BCryptPasswordEncoder 빈을 매개변수로 넘겨서 비밀번호를 암호화
        String encodedPassword = passwordEncoder.encode(memberRequest.getPassword());
        member.setPassword(encodedPassword);
        member.setRole(Role.USER);

        return member;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // 마우스라는 물체 -> 객체

    // 사용자 정의 타입 -> "클래스"
    // class Wheel

    // 가로, 세로, 휠, ... "속성" -> 필드
    // 왼쪽 클릭 누르면 -> action -> "기능" -> 메서드

}

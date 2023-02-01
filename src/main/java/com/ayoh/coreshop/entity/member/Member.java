package com.ayoh.coreshop.entity.member;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 회원 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "members")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Long id;

    // NOTE: 테이블 컬럼명과 자바 필드명이 일치하는 경우 @Column 애노테이션 생략 가능
    // @Column
    private String email;

    // NOTE: 가독성을 위해 모두 명시하거나, 애노테이션을 생략하는 방식 중 하나를 택하되 혼용해서 사용하지 말 것
    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String role;

    @Column(name = "created_at")
    private LocalDateTime createdDate;

    @Column(name = "updated_at")
    private LocalDateTime updatedDate;

}

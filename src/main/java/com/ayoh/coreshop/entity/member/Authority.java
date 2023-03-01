package com.ayoh.coreshop.entity.member;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * 권한 개체입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Table(name = "authorities")
@Entity
@Getter
@ToString
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_no")
    private Long id;

    @NotBlank
    @Size(max = 30)
    @Column(name = "authority_code")
    private String code;

}

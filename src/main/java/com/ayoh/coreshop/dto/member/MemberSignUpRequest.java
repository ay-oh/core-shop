package com.ayoh.coreshop.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 1. @Setter & @NoArgsConstructor
 * 2. ~~@Setter~~ & @AllArgsConstructor
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MemberSignUpRequest {

    private String email;
    private String password;
    private String name;
    private String address;

}

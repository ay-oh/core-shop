package com.ayoh.coreshop.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
// @Setter
public class MemberSignUpRequest {

    private final String email;
    private final String password;
    private final String name;
    private final String address;

}

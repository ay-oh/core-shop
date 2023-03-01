package com.ayoh.coreshop.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MemberLoginRequest {

    private final String email;
    private final String password;

}

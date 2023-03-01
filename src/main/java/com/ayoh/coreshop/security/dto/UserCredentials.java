package com.ayoh.coreshop.security.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class UserCredentials {

    private final String email;
    private final String password;

}

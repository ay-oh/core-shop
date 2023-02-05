package com.ayoh.coreshop.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberSignUpRequest {

    private String email;
    private String password;
    private String name;
    private String address;

}

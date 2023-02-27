package com.ayoh.coreshop.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// NOTE #4: Refactor > Delombok
@Getter
@Setter
@ToString
public class UserDto {

    private String name;
    private Integer age;
    private String ssn;

}

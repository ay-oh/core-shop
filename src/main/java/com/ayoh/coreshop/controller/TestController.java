package com.ayoh.coreshop.controller;

import com.ayoh.coreshop.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public UserDto test() {
        // NOTE #3:
        UserDto userDto = new UserDto();
        userDto.setAge(20);
        userDto.setName("hoon");

        return userDto;
    }

}

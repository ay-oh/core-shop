package com.ayoh.coreshop.controller;

import com.ayoh.coreshop.dto.UserDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 웹 애플리케이션(Web Application)이란 요청과 응답이 끊임없이 일어나는 과정으로 볼 수 있습니다.
 * NOTE #2: @RestController == @Controller + @ResponseBody
 */
@RestController
public class HelloRestController {

    // @RequestMapping(value = "/hello")
    // @RequestMapping(path = "/hello")
    // @RequestMapping("/hello")
    // @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @GetMapping(path = "/hello")
    public String helloWorld() {
        return "Hello, world!";
    }

    @GetMapping("/test")
    public UserDto test() {
        // NOTE #3:
        UserDto userDto = new UserDto();
        userDto.setAge(20);
        userDto.setName("hoon");

        return userDto;
    }

}

package com.coright.coreshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// NOTE #2: @RestController == @RequestBody + @Controller
@RestController
public class HelloController {

    // @GetMapping
    // @GetMapping(value = "/")
    // @GetMapping(path = "/")
    @GetMapping("/")
    public String helloWorld() {
        return "Hello, world!";
    }

}

package com.ayoh.coreshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 웹 애플리케이션(Application)이 뭔지?
 * @RestController == @Controller + @ResponseBody
 */
@RestController
public class HelloController {

    // @RequestMapping(value = "/hello")
    // @RequestMapping(path = "/hello")
    // @RequestMapping("/hello")
    // @RequestMapping(path = "/hello", method = RequestMethod.GET)
    @GetMapping(path = "/hello")
    public String hello() {
        return "Hello, ";
    }

}

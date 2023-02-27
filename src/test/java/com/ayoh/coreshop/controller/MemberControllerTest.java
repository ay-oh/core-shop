package com.ayoh.coreshop.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import com.ayoh.coreshop.controller.member.MemberController;
import com.ayoh.coreshop.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(controllers = MemberController.class)
class MemberControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    MemberService memberService;

    @BeforeEach
    void setUp(WebApplicationContext wac) {
        mockMvc = webAppContextSetup(wac).alwaysDo(print()).build();
    }

    @Test
    void testGoSignUpFormPage() {

    }

    @Test
    void testDoSignUp() {
    }

    @Test
    @DisplayName("로그인 페이지로 이동 요청 시 정상적인 로그인 페이지 반환 여부 테스트")
    void testGoLoginPage() throws Exception {
        mockMvc.perform(get("/login"))
               .andExpect(status().isOk())
               .andExpect(view().name("pages/members/login"));
    }

    @Test
    void testLoginError() {
    }

}
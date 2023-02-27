package com.ayoh.coreshop.security.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * 스프링 시큐리티를 통해 인증 및 인가를 관리하기 위한 구성 클래스입니다.
 *
 * @author CoRock
 * @version 1.0.0
 * @since 1.0.0
 */
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {

    private final AuthenticationSuccessHandler loginSuccessHandler;
    private final LogoutHandler logoutHandler;
    private final LogoutSuccessHandler logoutSuccessHandler;

    /**
     * 인증 및 인가 제어를 위한 보안 필터 체인입니다.
     *
     * @param http 인증, 인가 등의 세부적인 기능을 설정할 수 있는 API 를 제공하는 매개변수
     * @return 보안 처리와 관련된 필터 목록을 가진 SecurityFilterChain
     * @throws Exception HttpSecurity build 기능 수행 도중 발생하는 예외
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // http.csrf().disable();

        // permitAll only works with either HttpSecurity.authorizeRequests() or HttpSecurity.authorizeHttpRequests(). Please define one or the other but not both.
        http.authorizeHttpRequests()
            .anyRequest()
            .permitAll();

        http.formLogin()
            .loginPage("/login")
            .loginProcessingUrl("/auth/login")
            .defaultSuccessUrl("/")
            .successHandler(this.loginSuccessHandler)
            .permitAll();

        http.logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/login")
            .addLogoutHandler(this.logoutHandler)
            .logoutSuccessHandler(this.logoutSuccessHandler);

        return http.build();
    }

    /**
     * 비밀번호를 데이터베이스에 그대로 저장했을 경우, 데이터베이스가 해킹당했을 때 고객의 회원 정보가 그대로 노출됩니다.
     * 이를 해결하기 위해 BCryptPasswordEncoder 의 해시 함수를 이용하여 비밀번호를 암호화하여 저장합니다.
     *
     * @return 빈으로 등록한 PasswordEncoder 인터페이스
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}

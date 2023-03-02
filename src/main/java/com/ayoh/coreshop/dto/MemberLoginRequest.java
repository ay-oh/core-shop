package com.ayoh.coreshop.dto;

/**
 * 로그인 폼을 통해 로그인 시도 시 요청 객체입니다.
 * 의미상 {@link com.ayoh.coreshop.security.dto.UserCredentials} 클래스와 유사하다고 볼 수 있습니다.
 */
public class MemberLoginRequest {

    private final String email;
    private final String password;

    public MemberLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

}

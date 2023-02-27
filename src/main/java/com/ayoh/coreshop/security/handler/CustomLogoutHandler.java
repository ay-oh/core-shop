package com.ayoh.coreshop.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import static java.util.Objects.nonNull;

/**
 * 로그아웃을 요청을 수행하면서 부가적인 작업을 다루기 위한 커스텀 구현 클래스입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class CustomLogoutHandler implements LogoutHandler {

    /**
     * 로그아웃 요청 수행 시 세션을 무효화합니다.
     *
     * @param request        the HTTP request
     * @param response       the HTTP response
     * @param authentication the current principal details
     */
    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        HttpSession session = request.getSession(false);

        if (nonNull(session)) {
            session.invalidate();
        }
    }

}

package com.ayoh.coreshop.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 로그아웃을 성공적으로 수행한 뒤 부가적인 작업을 다루기 위한 커스텀 구현 클래스입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    /**
     * 로그아웃이 성공했을 때, 로그인 페이지로 리디렉션(redirection) 을 수행합니다.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     *                       the authentication process.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.sendRedirect("/login");
    }

}

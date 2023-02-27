package com.ayoh.coreshop.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * 로그인 성공 후 부가 작업을 수행하는 커스텀 핸들러 클래스입니다.
 *
 * @version 1.0.0
 * @since 1.0.0
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    public static final String SESSION_ID = "CSESSIONID";
    public static final String DEFAULT_TARGET_URL = "/";

    private final RequestCache requestCache;
    private final RedirectStrategy redirectStrategy;

    public LoginSuccessHandler() {
        this.requestCache = new HttpSessionRequestCache();
        this.redirectStrategy = new DefaultRedirectStrategy();
    }

    /**
     * 인증에 성공하면 사번 정보가 담긴 세션 아이디를 발급하고, 요청 캐시를 통해 메인 페이지("/")로 리디렉션(redirection)을 수행합니다.
     *
     * @param request        the request which caused the successful authentication
     * @param response       the response
     * @param authentication the <tt>Authentication</tt> object which was created during
     *                       the authentication process.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();
        session.setAttribute(SESSION_ID, authentication.getName());

        SavedRequest savedRequest = requestCache.getRequest(request, response);
        String targetUrl = DEFAULT_TARGET_URL;

        if (nonNull(savedRequest)) {
            targetUrl = savedRequest.getRedirectUrl();
        }

        // if (this.isFirstTimeLogin(authentication)) {
        //     targetUrl = "/auth/change-password";
        // }

        redirectStrategy.sendRedirect(request, response, targetUrl);
    }

    // private boolean isFirstTimeLogin(Authentication authentication) {
    //     return isNull(((CustomUserDetails) authentication.getPrincipal()).getLastLoginDate());
    // }

}

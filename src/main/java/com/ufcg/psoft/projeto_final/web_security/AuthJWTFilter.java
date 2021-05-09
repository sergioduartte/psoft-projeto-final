package com.ufcg.psoft.projeto_final.web_security;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.*;
import org.springframework.web.filter.GenericFilterBean;
import com.ufcg.psoft.projeto_final.*;

public class AuthJWTFilter extends GenericFilterBean {

    private final AuthTokenService authTokenService;

    public AuthJWTFilter(ApplicationContext ctx) {
        this.authTokenService = ctx.getBean(AuthTokenService.class);
    }

    @Override
    public void doFilter(ServletRequest request, 
    		ServletResponse response, 
    		FilterChain filterChain)
            throws IOException, ServletException {

    	Authentication auth = authTokenService.getAuth((HttpServletRequest) request);

        SecurityContextHolder.getContext().setAuthentication(auth);
        filterChain.doFilter(request, response);

    }

}

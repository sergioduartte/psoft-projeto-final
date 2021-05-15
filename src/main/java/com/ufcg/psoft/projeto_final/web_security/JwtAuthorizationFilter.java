package com.ufcg.psoft.projeto_final.web_security;


import com.ufcg.psoft.projeto_final.entidades.Login;
import com.ufcg.psoft.projeto_final.services.LoginService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private LoginService loginService;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws IOException, ServletException {
        if (loginService == null) {
            ServletContext servletContext = request.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
            loginService = webApplicationContext.getBean(LoginService.class);
        }
        UsernamePasswordAuthenticationToken authentication = getAuthentication(request);
        if (authentication == null) {
            filterChain.doFilter(request, response);
            return;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
        String token = request.getHeader(SecurityConstants.TOKEN_HEADER);
        if (token != null && !token.trim().isEmpty() && token.startsWith(SecurityConstants.TOKEN_PREFIX)) {
            try {
                byte[] signingKey = SecurityConstants.JWT_SECRET.getBytes();

                Jws<Claims> parsedToken = Jwts.parser()
                        .setSigningKey(signingKey)
                        .parseClaimsJws(token.replace("Bearer ", ""));

                String idString = parsedToken
                        .getBody()
                        .getSubject();

                if (idString != null && !idString.trim().isEmpty()) {
                    String login = idString;

                    Login user = loginService.findByUserLogin(login);

                    String rn = user.getLoginTipo();
                    List<GrantedAuthority> a = new ArrayList<GrantedAuthority>();

                    GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + rn);
                    a.add(authority);


                    if (user != null)
                        return new UsernamePasswordAuthenticationToken(user, null, a);
                    else
                        throw new Exception("Usuário não cadastrado");
                }
            } catch (Exception exception) {
                System.err.println(exception.getMessage());
            }

        }
        return null;
    }
}


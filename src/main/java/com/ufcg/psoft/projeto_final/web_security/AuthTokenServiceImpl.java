package com.ufcg.psoft.projeto_final.web_security;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.ufcg.psoft.projeto_final.entidades.*;
import com.ufcg.psoft.projeto_final.services.*;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class AuthTokenServiceImpl implements AuthTokenService {

    @Autowired
    LoginService loginService;

    static final long EXPIRATION_TIME = 86_400_000;
    //static final String SECRET = "16bd8dfba2191761b65d5a795806e530";
    static final String SECRET = "1e27ba40b0ea11eb85290242ac130003";                              
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    @Override
    public String createAuthToken(String login) {
        return Jwts.builder()
                .setSubject(login)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    @Override
    public Authentication getAuth(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            String login = Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();
            
            if (login != null) {
                Login userLogin = loginService.findByUserLogin(login);

                if (userLogin != null) {
                    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
                    authorities.add(new SimpleGrantedAuthority("ROLE_" + userLogin.getLoginTipo()));
                    return new UsernamePasswordAuthenticationToken(userLogin.getLogin(), "", authorities);
                }
            }

        }
        return null;
    }
}

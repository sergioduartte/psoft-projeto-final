package com.ufcg.psoft.projeto_final.web_security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

public interface AuthTokenService {
	
    String createAuthToken(String login);
    Authentication getAuth(HttpServletRequest request);
    
}

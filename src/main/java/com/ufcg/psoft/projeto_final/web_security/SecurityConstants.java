package com.ufcg.psoft.projeto_final.web_security;

public class SecurityConstants {

    public static final String AUTH_LOGIN_URL = "auth/login";

    public static final String TOKEN_KEY = "p3swhJQ2rzLbwPIdfmSr2vuherfr8ty5t5478y4bvr7857tyufvrg7c8g7dscw";


    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String TOKEN_TYPE = "JWT";
    public static final String TOKEN_ISSUER = "secure-api";
    public static final String TOKEN_AUDIENCE = "secure-app";

    private SecurityConstants() {
        throw new IllegalStateException
                ("Cannot create instance of static util class");
    }

}
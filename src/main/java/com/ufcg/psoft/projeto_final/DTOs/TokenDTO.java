package com.ufcg.psoft.projeto_final.DTOs;

import java.io.Serializable;

public class TokenDTO implements Serializable {

    private String token;

    public TokenDTO() {
    }

    public TokenDTO(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

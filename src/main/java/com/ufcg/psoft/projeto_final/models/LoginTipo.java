package com.ufcg.psoft.projeto_final.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoginTipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String loginTipo;

    public LoginTipo() {}

    public LoginTipo(Long id, String loginTipo) {
        this.id = id;
        this.loginTipo = loginTipo;
    }

    public LoginTipo(String loginTipo) {
        this.loginTipo = loginTipo;
    }

    public String getLoginTipo() {
        return loginTipo;
    }
}

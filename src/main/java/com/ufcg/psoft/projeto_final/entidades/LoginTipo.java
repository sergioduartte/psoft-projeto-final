package com.ufcg.psoft.projeto_final.entidades;

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

    public String getLoginTipo() {
        return loginTipo;
    }
}
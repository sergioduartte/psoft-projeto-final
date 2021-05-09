package com.ufcg.psoft.projeto_final.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class LoginCidadao {
    
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "login_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Login login;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cidadao_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Cidadao cidadao;

    public LoginCidadao(Login login, Cidadao cidadao) {
        this.login = login;
        this.cidadao = cidadao;
    }

    public LoginCidadao() {}

    public Login getLogin() {
        return login;
    }
}

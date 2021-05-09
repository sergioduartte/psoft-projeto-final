package com.ufcg.psoft.projeto_final.entidades;

import javax.persistence.*;

@Entity
public class Login {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(unique = true)
    private String login;
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    private LoginTipo loginTipo;

    public Login() { }

    public Login(String login, String senha, LoginTipo loginTipo) {
        this.login = login;
        this.password = senha;
        this.loginTipo = loginTipo;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return password;
    }

    public String getLoginTipo() {
        return loginTipo.getLoginTipo();
    }
}

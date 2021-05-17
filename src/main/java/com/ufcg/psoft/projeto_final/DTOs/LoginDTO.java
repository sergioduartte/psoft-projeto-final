package com.ufcg.psoft.projeto_final.DTOs;

public class LoginDTO {

    private String login;
    private String password;

    public LoginDTO(String login, String senha) {
        this.setLogin(login);
        this.setSenha(senha);
    }

    public LoginDTO() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return password;
    }

    public void setSenha(String senha) {
        this.password = senha;
    }


}

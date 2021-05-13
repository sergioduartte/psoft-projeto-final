package com.ufcg.psoft.projeto_final.entidades;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Comorbidade {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique = true)
    private String descricao;

    @NotNull
    private Boolean ehPrioritaria;

    public Comorbidade(String descricao) {
        this.descricao = descricao;
        this.ehPrioritaria = false;
    }

    public Comorbidade() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getEhPrioritaria() {
        return ehPrioritaria;
    }

    public void setEhPrioritaria(Boolean ehPrioritaria) {
        this.ehPrioritaria = ehPrioritaria;
    }
}

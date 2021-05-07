package com.ufcg.psoft.projeto_final.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vacina {
    //TODO colocar novos atributos
    @Id
    @GeneratedValue
    private long id;
    private String nome;

    public Vacina(){
        super();
    }
    public Vacina(long id, String nome){
        super();
        this.id = id;
        this.nome = nome;
    }
    public Vacina(String nome){
        super();
        this.nome = nome;
    }
    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    @Override
    public String toString() {
        return "Chora, paixão! Tá adicionando vacinaaaaa. Dale!\n[id da vacina=" + id + ", nome=" + nome + "]";
    }

}

package com.example.projeto_final_psoft.entidades;

import org.apache.tomcat.jni.Local;
import java.util.ArrayList;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
public class Lote {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vacina_id")
    private Vacina vacina;


    private Date data_validade;
    private int qtd_doses;
    private String tipo_vacina;

    public Lote() {
        super();
    }

    public Lote( Date data_validade, int qtd_doses, Vacina vacina) {
        super();
        this.vacina = vacina;
        this.data_validade = data_validade;
        this.qtd_doses = qtd_doses;
        this.tipo_vacina = tipo_vacina;

    }
    public int getQtdDoses(){
        return qtd_doses;
    }

    public void setQtdDoses( int qtd_doses){
        this.qtd_doses = qtd_doses;
    }

    public Date getDataValidade() {
        return data_validade;
    }

    public Long getId() {
        return id;
    }

    public Vacina getTipoVacina() {
        return vacina;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id: " + id +
                ", numero de doses: " + qtd_doses +
                ", data de validade: " + data_validade +
                "tipo da vacina: " + tipo_vacina + '\'' +
                '}';
    }
}


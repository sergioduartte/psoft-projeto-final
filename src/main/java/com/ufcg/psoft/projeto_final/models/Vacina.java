package com.ufcg.psoft.projeto_final.models;

import com.sun.istack.NotNull;
import com.ufcg.psoft.projeto_final.exceptions.CadastroVacinaException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotNull
    private String fabricante;
    @NotNull
    private Integer dosesNecessarias;
    @NotNull
    private Integer intervaloDoses;

    public Vacina() throws CadastroVacinaException {
    }

    public Vacina(String fabricante, Integer dosesNecessarias, Integer intervaloDoses) throws CadastroVacinaException {
        validaVacina(fabricante, dosesNecessarias, intervaloDoses);
        this.fabricante = fabricante;
        this.dosesNecessarias = dosesNecessarias;
        this.intervaloDoses = intervaloDoses;
    }

    public Long getId() {
        return id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Integer getDosesNecessarias() {
        return dosesNecessarias;
    }

    public Integer getIntervaloDoses() {
        return intervaloDoses;
    }

    private void validaVacina(String fabricante, Integer dosesNecessarias, Integer intervaloDoses) throws CadastroVacinaException {
        if (fabricante.trim() == "") {
            throw new CadastroVacinaException("Nome do fabricante nao pode ser vazio");
        }

        if (dosesNecessarias <= 0) {
            throw new CadastroVacinaException("Quantidade de doses não pode ser menor que 1.");
        } else if (dosesNecessarias > 2) {
            throw new CadastroVacinaException("Quantidade de doses não pode ser maior que 2.");
        }

        if (intervaloDoses <= 0) {
            throw new CadastroVacinaException("O intervalo das doses deve ser maior que 1 dia.");
        } else if (dosesNecessarias == 1) {
            if (intervaloDoses != 0) {
                throw new CadastroVacinaException("Não deve haver intevalo de doses com vacinas de dosagem única.");
            }
        }
    }
}
package com.ufcg.psoft.projeto_final.models;

import com.ufcg.psoft.projeto_final.exceptions.CadastroLoteException;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;


@Entity
public class Lote {

    @Id
    @GeneratedValue
    private Long id;

    private Date dataValidade;
    private int qtdDosesTotal;
    private String fabricante;
    private Long idTipoVacina;
    private int qtdDosesReservadas;
    private int qtdDosesUsadas;

    public Lote() {
        super();
    }

    public Lote(Date dataValidade, int qtdDosesTotal, String fabricante, Long idTipoVacina) throws CadastroLoteException {
        super();
        validaLote(dataValidade, qtdDosesTotal);
        this.dataValidade = dataValidade;
        this.qtdDosesTotal = qtdDosesTotal;
        this.fabricante = fabricante;
        this.idTipoVacina = idTipoVacina;
        this.qtdDosesReservadas = 0;
        this.qtdDosesUsadas = 0;

    }

    private void validaLote(Date dataValidade, int qtdDoses) throws CadastroLoteException {
        //TODO ver como testar a data
        if (qtdDoses <= 0) {
            throw new CadastroLoteException("Quantidade de doses não pode ser menor que 1.");
        }
    }

    public int getQtdDosesTotal() {
        return qtdDosesTotal;
    }

    public int getQtdDosesDisponiveis() {
        return this.qtdDosesTotal - this.qtdDosesUsadas;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public Long getId() {
        return id;
    }

    public String getFabricante() {
        return fabricante;
    }

    public Long getIdTipoVacina() {
        return idTipoVacina;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id: " + id +
                ", número de doses: " + qtdDosesTotal +
                ", data de validade: " + dataValidade +
                "tipo da vacina: " + fabricante + '\'' +
                '}';
    }

    public void reservaVacina() {
        if (qtdDosesReservadas < qtdDosesTotal) {
            qtdDosesReservadas++;
        }
    }

    public void usaDose() {
        qtdDosesUsadas++;
    }
}


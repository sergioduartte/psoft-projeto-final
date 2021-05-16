package com.ufcg.psoft.projeto_final.entidades;

import com.ufcg.psoft.projeto_final.exceptions.CadastroLoteException;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Lote {

    @Id
    @GeneratedValue
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "vacina_id") //TODO comentei isso pois não entendi a importancia de ter Vacina no Lote, se só
//    private Vacina vacina;          //TODO precisa de saber o tipo, que é o ID do tipo da vacina, esse join n casa os IDs, casa as tabelas


    private Date dataValidade;
    private int qtdDosesTotal;
    private String fabricante;
    private Long idTipoVacina;
    private int qtdDosesReservadas;

    public Lote() {
        super();
    }

    public Lote(Date dataValidade, int qtdDosesTotal, String fabricante, Long idTipoVacina) throws CadastroLoteException{
        super();
        validaLote(dataValidade, qtdDosesTotal);
        this.dataValidade = dataValidade;
        this.qtdDosesTotal = qtdDosesTotal;
        this.fabricante = fabricante;
        this.idTipoVacina = idTipoVacina; //TODO Conversar sobre esse design
        this.qtdDosesReservadas = 0;

    }

    private void validaLote(Date dataValidade, int qtdDoses) throws CadastroLoteException{
        //TODO ver como testar a data
        if (qtdDoses <= 0) {
            throw new CadastroLoteException("Quantidade de doses não pode ser menor que 1.");
        }
    }

    public int getQtdDosesTotal(){
        return qtdDosesTotal;
    }

    public int getQtdDosesDisponiveis(){
        return getQtdDosesDisponiveis();
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
}


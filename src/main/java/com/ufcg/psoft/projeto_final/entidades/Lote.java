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
    private int qtdDoses;
    private String tipoVacina;
    private Long idTipoVacina;

    public Lote() {
        super();
    }

    public Lote(Date dataValidade, int qtdDoses, String tipoVacina, Long idTipoVacina) throws CadastroLoteException{
        super();
        validaLote(dataValidade, qtdDoses);
        this.dataValidade = dataValidade;
        this.qtdDoses = qtdDoses;
        this.tipoVacina = tipoVacina;
        this.idTipoVacina = idTipoVacina; //TODO Conversar sobre esse design

    }

    private void validaLote(Date dataValidade, int qtdDoses) throws CadastroLoteException{
        //TODO ver como testar a data
        if (qtdDoses <= 0) {
            throw new CadastroLoteException("Quantidade de doses não pode ser menor que 1.");
        }
    }

    public int getQtdDoses(){
        return qtdDoses;
    }

    public void setQtdDoses( int qtd_doses){
        this.qtdDoses = qtd_doses;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public Long getId() {
        return id;
    }

    public String getTipoVacina() {
        return tipoVacina;
    }

    @Override
    public String toString() {
        return "Lote{" +
                "id: " + id +
                ", número de doses: " + qtdDoses +
                ", data de validade: " + dataValidade +
                "tipo da vacina: " + tipoVacina + '\'' +
                '}';
    }
}


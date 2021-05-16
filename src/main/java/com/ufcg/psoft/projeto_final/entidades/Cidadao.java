package com.ufcg.psoft.projeto_final.entidades;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sun.istack.NotNull;
import com.ufcg.psoft.projeto_final.entidades.situacoes.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * 
 * Classe dedicada a entidade Cidadao.
 * Gets e Sets relacionados aos parametros de Cidadao.
 * Metodos de manipulacao do Set de Comorbidades. 
 *
 */

@Entity
public class Cidadao {

    private String nome;
    private String endereco;
    @Id
    private Long cpf;

    @NotNull
    @Column(unique = true)
    private String cartaoSus;

    @NotNull
    @Column(unique = true)
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String telefone;
    private String profissao;

    @ElementCollection
    @CollectionTable(name = "cidadao_cormobidade", joinColumns = @JoinColumn(name = "cidadao_id"))
    @JoinColumn(name = "cidadao_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private List<String> cormobidade;
    @Enumerated(EnumType.STRING)
    private EnumSituacoes situacao;
    private Long idVacina;
    private Long idUltimoAgendamento;

    public Cidadao() {}

    public Cidadao(String nome, String endereco, Long cpf, String cartaoSus, String email, Date dataNascimento, String telefone, String profissao, List<String> cormobidade) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cartaoSus = cartaoSus;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.setTelefone(telefone);
        this.setProfissao(profissao);
        this.cormobidade = cormobidade;
        this.situacao = EnumSituacoes.NAO_APTO;
    }

    public int getIdade(){
        //TODO para habilitacao
        return -1;
    }

    public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}
	
	public void setSituacao(EnumSituacoes situacao){
        this.situacao = situacao;
	}

	public EnumSituacoes getSituacao(){
		return this.situacao;
	}

    public Long getId() { return this.cpf; }

    public Collection<Object> getComorbidades() {
        // TODO para habilitacao
        return null;
    }

    public Long getIdVacina() { return idVacina; }

    public Long getIdUltimoAgendamento() { return this.idUltimoAgendamento; }

    public void setUltimoAgendamento(Long idUltimoAgendamento) { this.idUltimoAgendamento = idUltimoAgendamento; }
}

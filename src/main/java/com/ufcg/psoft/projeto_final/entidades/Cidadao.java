package com.ufcg.psoft.projeto_final.entidades;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ufcg.psoft.projeto_final.exceptions.CadastroCidadaoException;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.sun.istack.NotNull;
import com.ufcg.psoft.projeto_final.entidades.situacoes.*;

import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    private String email;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String telefone;
    private String profissao;

    @ElementCollection
    private List<String> comorbidades;

    @Enumerated(EnumType.STRING)
    private EnumSituacoes situacao;
    private Long idVacina;
    private Long idUltimoAgendamento;

    public Cidadao() {}

    public Cidadao(String nome, String endereco, Long cpf, String cartaoSus, String email, Date dataNascimento,
                   String telefone, String profissao, List<String> comorbidades) throws CadastroCidadaoException {

        validaCidadao(nome, endereco, cpf, cartaoSus, email, dataNascimento,
                telefone, profissao, comorbidades);
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.cartaoSus = cartaoSus;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
        this.profissao = profissao;
        this.comorbidades = comorbidades;
        this.situacao = EnumSituacoes.NAO_APTO;
    }

    private void validaCidadao(String nome, String endereco, Long cpf, String cartaoSus, String email, Date dataNascimento,
                               String telefone, String profissao, List<String> comorbidades) throws CadastroCidadaoException {

        // TODO nome nao pode ser vazio ou menor que 4 letras
        if (nome.length() < 5 || nome.trim().isEmpty()) {
            throw new CadastroCidadaoException ("Nome do Cidadao nao pode ter menos de 5 caracteres.");
        }

        // TODO endereco nao pode ser vazio
        if (endereco.trim().isEmpty()){
            throw new CadastroCidadaoException ("Endereco nao pode ser vazio.");
        }
        // TODO cpf nao pode ser nulo, (checar algum metodo de checagem de cpf)
        if (cpf == null) {
            throw new CadastroCidadaoException ("CPF nao esta no formato correto.");
        }
        // TODO cartaoSus tem de ter 15 digitos
        if (cartaoSus.length() < 15) {
            throw new CadastroCidadaoException ("O numero do cartao do SUS esta fora do formato.");
        }
        // TODO email procurar como validar (projetoP2-sergio)
        Pattern p = Pattern.compile("[\\w\\d_\\.%\\+-]+@[\\w\\d\\.-]+\\.[\\w]{2,6}");
        Matcher m = p.matcher(email);

        if (!m.matches()) {
            throw new CadastroCidadaoException( "Formato de e-mail esta invalido.");
        }

        // TODO checar se nao nasceu depois de hoje
        Date hoje = java.util.Calendar.getInstance().getTime();
        if (!dataNascimento.before(hoje)) {
            throw new CadastroCidadaoException( "Data de Nascimento deve ser apos o dia corrente.");
        }
        // TODO telefone tem de ter 13 digitos// TODO cartaoSus tem de ter 15 digitos
        if (telefone.length() < 13) {
            throw new CadastroCidadaoException ("O numero do Telefone esta fora do formato \"5583999998888\".");
        }

        // TODO profissao nao pode ser vazio
        if (profissao.trim().isEmpty()){
            throw new CadastroCidadaoException ("Profissao nao pode ser vazia.");
        }
        // TODO comorbidades pode ser vazio, não nulo
        if (comorbidades == null) {
            throw new CadastroCidadaoException ("Comorbidades nao pode ser nula.");
        }
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

    public List<String> getComorbidades() {
        return comorbidades;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setComorbidades(List<String> cormobidade) {
        this.comorbidades = cormobidade;
    }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Long getIdVacina() { return idVacina; }

    public Long getIdUltimoAgendamento() { return this.idUltimoAgendamento; }

    public void setUltimoAgendamento(Long idUltimoAgendamento) { this.idUltimoAgendamento = idUltimoAgendamento; }

    public Long getCpf() {
        return cpf;
    }
}

package com.ufcg.psoft.projeto_final.models;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.ufcg.psoft.projeto_final.exceptions.CadastroCidadaoException;

import com.sun.istack.NotNull;
import com.ufcg.psoft.projeto_final.models.situacoes.*;

import java.time.*;
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
    private String senha;

    public Cidadao() {}

    public Cidadao(String nome, String endereco, Long cpf, String cartaoSus, String email, Date dataNascimento,
                   String telefone, String profissao, List<String> comorbidades, String senha) throws CadastroCidadaoException {

        validaCidadao(nome, endereco, cpf, cartaoSus, email, dataNascimento,
                telefone, profissao, comorbidades, senha);
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
        this.senha = senha;
    }

    private void validaCidadao(String nome, String endereco, Long cpf, String cartaoSus, String email, Date dataNascimento,
                               String telefone, String profissao, List<String> comorbidades, String senha) throws CadastroCidadaoException {

        // nome nao pode ser vazio ou menor que 4 letras
        if (nome.length() < 5 || nome.trim().isEmpty()) {
            throw new CadastroCidadaoException ("Nome do Cidadao nao pode ter menos de 5 caracteres.");
        }
        // endereco nao pode ser vazio
        if (endereco.trim().isEmpty()){
            throw new CadastroCidadaoException ("Endereco nao pode ser vazio.");
        }
        // cpf nao pode ser nulo, (checar algum metodo de checagem de cpf)
        if (cpf == null) {
            throw new CadastroCidadaoException ("CPF nao esta no formato correto.");
        }
        // cartaoSus tem de ter 15 digitos
        if (cartaoSus.length() < 15) {
            throw new CadastroCidadaoException ("O numero do cartao do SUS esta fora do formato.");
        }
        // padrao <palavra><numero><.%+->@<palavra><numero><.->.<palavraDeTamanho2a6>
        Pattern p = Pattern.compile("[\\w\\d_\\.%\\+-]+@[\\w\\d\\.-]+\\.[\\w]{2,6}");
        Matcher m = p.matcher(email);

        if (!m.matches()) {
            throw new CadastroCidadaoException( "Formato de e-mail esta invalido.");
        }

        // checar se nao nasceu depois de hoje
        Date hoje = java.util.Calendar.getInstance().getTime();
        if (!dataNascimento.before(hoje)) {
            throw new CadastroCidadaoException( "Data de Nascimento deve ser apos o dia corrente.");
        }
        // telefone tem de ter 11 digitos
        if (telefone.length() < 11) {
            throw new CadastroCidadaoException ("O numero do Telefone esta fora do formato \"83999998888\".");
        }

        // profissao nao pode ser vazio
        if (profissao.trim().isEmpty()){
            throw new CadastroCidadaoException ("Profissao nao pode ser vazia.");
        }
        // comorbidades pode ser vazio, não nulo
        if (comorbidades == null) {
            throw new CadastroCidadaoException ("Comorbidades nao pode ser nula.");
        }
        // senha deve ter letras e numeros
        Pattern pSenha = Pattern.compile("[\\w\\d]{8}");
        Matcher matcher = pSenha.matcher(senha);
        if (!matcher.matches()){
            throw new CadastroCidadaoException( "Formato da senha deve ter 8 caracteres e ser formado por letras e numeros");
        }
    }

    public int getIdade(){
        Instant instant = this.dataNascimento.toInstant();
        ZonedDateTime zone = instant.atZone(ZoneId.systemDefault());
        LocalDate givenDate = zone.toLocalDate();
        Period periodo = Period.between(givenDate, LocalDate.now());
        return periodo.getYears();
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

    public Long getCpf() { return cpf; }

    public String getSenha() { return this.senha; }
}

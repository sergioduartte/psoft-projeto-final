package com.ufcg.psoft.projeto_final.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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

	@Column(unique = true)
	private String cpf;
	private String numeroSUS;
	private String email;
	private LocalDate dataNascimento;
	private String telefone;
	private String profissao;

//TODO    @ElementCollection(fetch = FetchType.EAGER)
//    @CollectionTable(name="cidadao_comorbidade",
//            joinColumns = @JoinColumn(name = "cpf"))
//    @Column(name="comorbidades")
//    private Set<String> comorbidades;

    @Id
    @GeneratedValue
    private Long id;

    /**
	 * Construtor de Cidadao
	 * 
	 * @param nome
	 * @param endereco
	 * @param cpf
	 * @param numeroSUS
	 * @param email
	 * @param dataNascimento
	 * @param telefone
	 * @param profissao
	 //TODO* @param comorbidades
	 * 
	 */
	
	public Cidadao(String nome, String endereco, String cpf, String numeroSUS, String email, String dataNascimento,
			String telefone, String profissao) { //, String comorbidades) { depois adiciona de novo ~sergio
		this.nome = nome;
        this.cpf = cpf;
        this.endereco = endereco;
        this.numeroSUS = numeroSUS;
        this.email = email;
        this.telefone = telefone;
        this.profissao = profissao;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        this.setDataNascimento(LocalDate.parse(dataNascimento, formatter));
        //TODO setComorbidades(comorbidades);
	}

    public Cidadao() {

    }


//    TODO/**
//	 * Metodo que adiciona comorbidade.
//	 *
//	 * @param comorbidade
//	 */
//    public void adicionaComorbidade(String comorbidade) {
//        this.comorbidades.add(comorbidade);
//    }
    
    //gets
    public String getNome() {
        return this.nome;
    }

    public String getCpf() {
        return this.cpf;
    }
   
    public String getEndereco() {
        return this.endereco;
    }

    public String getNumeroSUS() {
        return this.numeroSUS;
    }    

    public String getEmail() {
        return this.email;
    }   

    public String getTelefone() {
        return this.telefone;
    }    

    public String getProfissao() {
        return this.profissao;
    }    

//TODO    public Set<String> getComorbidades() {
//        return this.comorbidades;
//    }
    
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
    

    //sets
    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }
    
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setNumeroSUS(String cartaoSUS) {
        this.numeroSUS = cartaoSUS;
    }
    
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
//TODO    public void setComorbidades(String comorbidades){
//
//    	Set<String> aux = new TreeSet<String>();
//
//    	for (String comorbidade : comorbidades.split(" ")){
//            aux.add(comorbidade);
//        }
//
//    	this.comorbidades = aux;
//    }

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }
}

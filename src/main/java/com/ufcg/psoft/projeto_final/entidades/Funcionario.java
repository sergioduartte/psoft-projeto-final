package com.ufcg.psoft.projeto_final.entidades;

import com.ufcg.psoft.projeto_final.exceptions.CadastroCidadaoException;
import com.ufcg.psoft.projeto_final.exceptions.CadastroFuncionarioException;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Funcionario {

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    private Cidadao cidadao;

    private String cargo;
    private String localTrabalho;

	public Funcionario(Cidadao cidadao, String cargo, String localTrabalho) throws CadastroFuncionarioException {
		validaFuncionario(cargo, localTrabalho);
		this.cidadao = cidadao;
		this.cargo = cargo;
		this.localTrabalho = localTrabalho;
	}

	private void validaFuncionario(String cargo, String localTrabalho) throws CadastroFuncionarioException {
		if (cargo.trim().isEmpty()){
			throw new CadastroFuncionarioException("Cargo nao pode ser vazio.");
		}
		if (localTrabalho.trim().isEmpty()){
			throw new CadastroFuncionarioException("Local de Trabalho nao pode ser vazio.");
		}
	}

	public Funcionario() {
    }

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getLocalTrabalho() {
		return localTrabalho;
	}

	public void setLocalTrabalho(String localTrabalho) {
		this.localTrabalho = localTrabalho;
	}

    public Long getCpf() {
		return this.cidadao.getCpf();
    }

	public String getSenha() {
		return this.cidadao.getSenha();
	}
}

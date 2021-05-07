package com.ufcg.psoft.projeto_final.entidades;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class VacinaJa {
	
	private Map<String, Cidadao> cidadaosCadastrados;
	private Set<String> comorbidades;
		
	public VacinaJa() {
		
		this.cidadaosCadastrados = new HashMap<String, Cidadao>();
        this.comorbidades = new TreeSet<String>();
		
	}
	
	/**
	 * 
	 * Metodo que adiciona Cidadao ao cadastro (HashMap).
	 * Utiliza os mesmo atributos de Cidadao.
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
	 */
    public void adicionaCidadao(String nome, String endereco, String cpf, String numeroSUS, String email, String dataNascimento,
			String telefone, String profissao, String comorbidades){
        
    	if(cidadaosCadastrados.containsKey(cpf)){
            System.out.println("CPF: " + cpf + " ja cadastrado.\n\n");
        } else {            
            Cidadao cidadao = new Cidadao(nome, endereco, cpf, numeroSUS, email, dataNascimento, telefone, profissao);// TODO, comorbidades); depois add dnv ~sergio
            cidadaosCadastrados.put(cpf, cidadao);
        }
    	
    }

    public Map<String, Cidadao> getCidadaosCadastrados() {
        return this.cidadaosCadastrados;
    }
    
    /**
     * Metodo que adiciona Comorbidades
     * @param comorbidade
     */
    public void adicionaComorbidade(String comorbidade){
        this.comorbidades.add(comorbidade);       
    }

// TODO
//    public void setComorbidades(String cpf, String comorbidades){
//        this.cidadaosCadastrados.get(cpf).setComorbidades(comorbidades);
//    }
    
    public void setCidadaosCadastrados(Map<String, Cidadao> cidadaosCadastrados) {
        this.cidadaosCadastrados = cidadaosCadastrados;
    }
    
    public Set<String> getComorbidades() {
        return this.comorbidades;
    }
    
}

package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Funcionario;

import java.util.List;

import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface FuncionarioService {
    public ResponseEntity<?> save(FuncionarioDTO funcionario);

    public Cidadao habilita(Long id);
    
	public List<Cidadao> habilitaPorIdade(Integer idade);

    public List<Cidadao> habilitaPorComorbidade(String comorbidade);

    public List<Cidadao> habilitaPorProfissao(String profissao);

    Funcionario aprovaCadastro(Long cpf) throws LoginTipoInvalido;

    void reprovaCadastro(Long cpf);
}

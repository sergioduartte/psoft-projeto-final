package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.entidades.Cidadao;
import com.ufcg.psoft.projeto_final.entidades.Funcionario;

import java.util.List;

import com.ufcg.psoft.projeto_final.erro.FuncionarioCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.FuncionarioNaoEncontrado;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface FuncionarioService {

    Funcionario saveFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioNaoEncontrado, FuncionarioCadastroInvalido;

    Cidadao habilita(Long id);

    List<Cidadao> habilitaPorIdade(Integer idade);

    List<Cidadao> habilitaPorComorbidade(String comorbidade);

    List<Cidadao> habilitaPorProfissao(String profissao);

    Funcionario aprovaCadastro(Long cpf) throws FuncionarioNaoEncontrado;

    void reprovaCadastro(Long cpf);
}
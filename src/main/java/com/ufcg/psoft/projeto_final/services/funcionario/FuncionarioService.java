package com.ufcg.psoft.projeto_final.services.funcionario;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.models.Cidadao;
import com.ufcg.psoft.projeto_final.models.Funcionario;

import java.util.List;

import com.ufcg.psoft.projeto_final.errors.FuncionarioCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.FuncionarioNaoEncontrado;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
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
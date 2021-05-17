package com.ufcg.psoft.projeto_final.services.funcionario;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.errors.FuncionarioCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.FuncionarioNaoEncontrado;
import com.ufcg.psoft.projeto_final.errors.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.exceptions.CadastroFuncionarioException;
import com.ufcg.psoft.projeto_final.exceptions.CidadaoNaoEncontradoException;
import com.ufcg.psoft.projeto_final.models.Cidadao;
import com.ufcg.psoft.projeto_final.models.Funcionario;
import com.ufcg.psoft.projeto_final.models.situacoes.EnumSituacoes;
import com.ufcg.psoft.projeto_final.models.situacoes.Situacao;
import com.ufcg.psoft.projeto_final.repositories.CidadaoRepository;
import com.ufcg.psoft.projeto_final.repositories.FuncionarioAnaliseRepository;
import com.ufcg.psoft.projeto_final.repositories.FuncionarioRepository;
import com.ufcg.psoft.projeto_final.services.cidadao.CidadaoService;
import com.ufcg.psoft.projeto_final.services.login.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    CidadaoService cidadaoService;

    @Autowired
    FuncionarioAnaliseRepository funcionarioAnaliseRepository;

    @Autowired
    FuncionarioRepository funcionarioRepository;

    @Autowired
    CidadaoRepository cidadaoRepository;

    @Autowired
    LoginService loginService;


    @Override
    public Funcionario saveFuncionario(FuncionarioDTO funcionarioDTO) throws FuncionarioNaoEncontrado, FuncionarioCadastroInvalido {
        Cidadao cidadao;
        try {
            cidadao = cidadaoService.getCidadao(funcionarioDTO.getCpf());
        } catch (CidadaoNaoEncontradoException e) {
            throw new FuncionarioNaoEncontrado(funcionarioDTO.getCpf());
        }

        Funcionario novoFuncionario;

        try {
            novoFuncionario = new Funcionario(cidadao, funcionarioDTO.getCargo(),
                    funcionarioDTO.getLocalTrabalho());
        } catch (CadastroFuncionarioException e) {
            throw new FuncionarioCadastroInvalido(e.getMessage());
        }

        funcionarioAnaliseRepository.save(novoFuncionario);

        return novoFuncionario;
    }

    @Override
    public Cidadao habilita(Long id) {
        Cidadao cidadao = cidadaoRepository.getOne(id);

        EnumSituacoes enumSituacao = cidadao.getSituacao();
        Situacao situacao = enumSituacao.getSituacao();
        situacao.habilitaCidadao(cidadao);

        cidadaoService.notificaAptoParaVacina(id);

        return cidadao;
    }

    @Override
    public List<Cidadao> habilitaPorIdade(Integer idadeMinima) {
        List<Cidadao> cidadaos = cidadaoRepository.findAll();
        List<Cidadao> habilitados = new ArrayList<>();
        for (Cidadao cidadao : cidadaos) {
            if (idadeMinima.compareTo(cidadao.getIdade()) <= 0) {
                habilitados.add(habilita(cidadao.getId()));
            }
        }
        return habilitados;
    }

    @Override
    public List<Cidadao> habilitaPorComorbidade(String comorbidade) {
        List<Cidadao> cidadaos = cidadaoRepository.findAll();
        List<Cidadao> habilitados = new ArrayList<>();
        for (Cidadao cidadao : cidadaos) {
            if (cidadao.getComorbidades().contains(comorbidade)) {
                habilitados.add(habilita(cidadao.getId()));
            }
        }
        return habilitados;
    }

    @Override
    public List<Cidadao> habilitaPorProfissao(String profissao) {
        List<Cidadao> cidadaos = cidadaoRepository.findAll();
        List<Cidadao> habilitados = new ArrayList<>();
        for (Cidadao cidadao : cidadaos) {
            if (cidadao.getProfissao().equals(profissao)) {
                habilitados.add(habilita(cidadao.getId()));
            }
        }
        return habilitados;
    }

    @Override
    public Funcionario aprovaCadastro(Long cpf) throws FuncionarioNaoEncontrado {


        Funcionario funcionario = funcionarioAnaliseRepository.findByCpf(cpf).get();
        if (funcionario == null) {
            throw new FuncionarioNaoEncontrado(cpf);
        }
        try {
            loginService.habilitaFuncionario(funcionario.getCpf().toString());
        } catch (LoginTipoInvalido loginTipoInvalido) {
            loginTipoInvalido.printStackTrace();
        }

        funcionarioAnaliseRepository.delete(funcionario);

        return funcionario;
    }

    @Override
    public void reprovaCadastro(Long cpf) {
        Funcionario funcionario = funcionarioAnaliseRepository.findByCpf(cpf).get();

        funcionarioAnaliseRepository.delete(funcionario);
    }
}

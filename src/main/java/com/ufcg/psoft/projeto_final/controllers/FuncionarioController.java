package com.ufcg.psoft.projeto_final.controllers;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.DTOs.RegistroVacinacaoDTO;
import com.ufcg.psoft.projeto_final.errors.FuncionarioCadastroInvalido;
import com.ufcg.psoft.projeto_final.errors.FuncionarioNaoEncontrado;
import com.ufcg.psoft.projeto_final.errors.RegistroInvalido;
import com.ufcg.psoft.projeto_final.models.Cidadao;
import com.ufcg.psoft.projeto_final.models.Funcionario;
import com.ufcg.psoft.projeto_final.models.RegistroVacinacao;
import com.ufcg.psoft.projeto_final.services.cidadao.CidadaoService;
import com.ufcg.psoft.projeto_final.services.funcionario.FuncionarioService;
import com.ufcg.psoft.projeto_final.services.registro.RegistroVacinacaoService;

import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class FuncionarioController {

    @Autowired
    FuncionarioService funcionarioService;

    @Autowired
    CidadaoService cidadaoService;

    @Autowired
    RegistroVacinacaoService registroVacinacaoService;

    @ApiOperation(value = "Salva um funcionario")
    @PostMapping("/funcionario")
    public ResponseEntity<Funcionario> funcionario(@RequestBody FuncionarioDTO funcionarioDTO) throws FuncionarioNaoEncontrado, FuncionarioCadastroInvalido {
        Funcionario funcionario = funcionarioService.saveFuncionario(funcionarioDTO);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }

    @ApiOperation(value = "Aprova o cadastro de um cidadão")
    @PostMapping("/funcionario/aprova_cadastro/")
    public ResponseEntity<Funcionario> aprovaFuncionario(@RequestBody Long cpf) throws FuncionarioNaoEncontrado {
        Funcionario funcionario = funcionarioService.aprovaCadastro(cpf);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Reprova o cadastro de um cidadão")
    @PostMapping("/funcionario/reprova_cadastro/")
    public ResponseEntity<?> reprovaCadastroFuncionario(@RequestBody Long cpf) {
        funcionarioService.reprovaCadastro(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @ApiOperation(value = "Habilita, pela idade, um cidadão a ser vacinado")
    @PostMapping("/funcionario/habilita_por_idade/")
    public ResponseEntity<List<Cidadao>> habilitaCidadaoPorIdade(@RequestBody Integer idade) {
        List<Cidadao> habilitados = funcionarioService.habilitaPorIdade(idade);
        return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);
    }

    @ApiOperation(value = "Habilita, por comorbidade, um cidadão a ser vacinado")
    @PostMapping("/funcionario/habilita_por_comorbidade/")
    public ResponseEntity<List<Cidadao>> habilitaCidadaoPorComorbidade(@RequestBody String comorbidade) {
        List<Cidadao> habilitados = funcionarioService.habilitaPorComorbidade(comorbidade);
        return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);
    }

    @ApiOperation(value = "Habilita, por profissao, um cidadão a ser vacinado")
    @PostMapping("/funcionario/habilita_por_profissao/")
    public ResponseEntity<List<Cidadao>> habilitaCidadaoPorProfissao(@RequestBody String profissao) {
        List<Cidadao> habilitados = funcionarioService.habilitaPorComorbidade(profissao);

        return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);

    }

    @ApiOperation(value = "Registra aplicação de uma dose de uma vacina")
    @PostMapping("/registroAplicacaoDose")
    public ResponseEntity<RegistroVacinacao> registraAplicacaoaDose(@RequestBody RegistroVacinacaoDTO registroVacinacaoDTO) throws RegistroInvalido {

        RegistroVacinacao registroVacinacao = registroVacinacaoService.saveRegistro(registroVacinacaoDTO);

        return new ResponseEntity<RegistroVacinacao>(registroVacinacao, HttpStatus.CREATED);


    }
}
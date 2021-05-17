package com.ufcg.psoft.projeto_final.controller;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import com.ufcg.psoft.projeto_final.DTOs.RegistroVacinacaoDTO;
import com.ufcg.psoft.projeto_final.entidades.*;

import com.ufcg.psoft.projeto_final.erro.FuncionarioCadastroInvalido;
import com.ufcg.psoft.projeto_final.erro.FuncionarioNaoEncontrado;
import com.ufcg.psoft.projeto_final.erro.LoginTipoInvalido;
import com.ufcg.psoft.projeto_final.erro.RegistroInvalido;
import com.ufcg.psoft.projeto_final.services.FuncionarioService;
import com.ufcg.psoft.projeto_final.services.CidadaoService;

import java.util.List;
import java.util.Optional;

import com.ufcg.psoft.projeto_final.services.RegistroVacinacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/funcionario")
    public ResponseEntity<Funcionario> funcionario(@RequestBody FuncionarioDTO funcionarioDTO) throws FuncionarioNaoEncontrado, FuncionarioCadastroInvalido {
        Funcionario funcionario = funcionarioService.saveFuncionario(funcionarioDTO);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.OK);
    }

    @PostMapping("/funcionario/aprova_cadastro/{cpf}/")
    public ResponseEntity<Funcionario> aprovaFuncionario(@RequestParam Long cpf) throws FuncionarioNaoEncontrado {
        Funcionario funcionario = funcionarioService.aprovaCadastro(cpf);
        return new ResponseEntity<Funcionario>(funcionario, HttpStatus.CREATED);
    }

    @PostMapping("/funcionario/reprova_cadastro/{cpf}/")
    public ResponseEntity<?> reprovaCadastroFuncionario(@PathVariable Long cpf){
        funcionarioService.reprovaCadastro(cpf);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/funcionario/habilita_por_idade/{idade}")
    public ResponseEntity<List<Cidadao>> habilitaCidadaoPorIdade(@RequestParam Integer idade){
        List<Cidadao> habilitados = funcionarioService.habilitaPorIdade(idade);

        return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);

    }

    @PostMapping("/funcionario/habilita_por_comorbidade/{comorbidade}")
    public ResponseEntity<List<Cidadao>> habilitaCidadaoPorComorbidade(@RequestParam String comorbidade){
        List<Cidadao> habilitados = funcionarioService.habilitaPorComorbidade(comorbidade);

        return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);

    }

    @PostMapping("/funcionario/habilita_por_profissao/{profissao}")
    public ResponseEntity<List<Cidadao>> habilitaCidadaoPorProfissao(@RequestParam String profissao){
        List<Cidadao> habilitados = funcionarioService.habilitaPorComorbidade(profissao);

        return new ResponseEntity<List<Cidadao>>(habilitados, HttpStatus.OK);

    }

    @PostMapping("/registroPrimeiraDose")
    public ResponseEntity<RegistroVacinacao> registraAplicacaoPrimeiraDose(@RequestBody RegistroVacinacaoDTO registroVacinacaoDTO) throws RegistroInvalido {

        RegistroVacinacao registroVacinacao = registroVacinacaoService.saveRegistro(registroVacinacaoDTO);

        return new ResponseEntity<RegistroVacinacao>(registroVacinacao, HttpStatus.CREATED);


    }
}
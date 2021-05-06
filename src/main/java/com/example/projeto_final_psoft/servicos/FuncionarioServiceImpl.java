package com.example.projeto_final_psoft.servicos;

import com.example.projeto_final_psoft.DTOs.FuncionarioDTO;
import com.example.projeto_final_psoft.entidades.Cidadao;
import com.example.projeto_final_psoft.entidades.Funcionario;
import com.example.projeto_final_psoft.repositorios.FuncionarioAnaliseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FuncionarioServiceImpl implements  FuncionarioService {

    @Autowired
    CidadaoService cidadaoService;

    @Autowired
    FuncionarioAnaliseRepository funcionarioAnaliseRepository;

    @Override
    public ResponseEntity<?> adicionaFuncionario(FuncionarioDTO funcionario) {
        Optional<Cidadao> optionalCidadao = cidadaoService.getCidadao(funcionario.getCpf());
        if (optionalCidadao.isPresent()) {
            // return ErroCidadao.cidadaoJaCadastrado(cidadao.getCpf());
            return null;
        }

        Cidadao cidadao = optionalCidadao.get();
        // Removi o cidadao.getComorbidades().toString() ~Sergio
        Funcionario novoFuncionario = new Funcionario(cidadao.getNome(), cidadao.getEndereco(), cidadao.getCpf(),
                cidadao.getNumeroSUS(), cidadao.getEmail(), cidadao.getDataNascimento().toString(),
                cidadao.getTelefone(), cidadao.getProfissao(), funcionario.getCargo(),
                funcionario.getLocalTrabalho());

        funcionarioAnaliseRepository.save(novoFuncionario);

        return new ResponseEntity<>(novoFuncionario, HttpStatus.CREATED);
    }
}

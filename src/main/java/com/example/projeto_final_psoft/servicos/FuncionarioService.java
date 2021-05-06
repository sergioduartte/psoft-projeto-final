package com.example.projeto_final_psoft.servicos;

import com.example.projeto_final_psoft.DTOs.FuncionarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface FuncionarioService {
    ResponseEntity<?> adicionaFuncionario(FuncionarioDTO funcionario);
}

package com.ufcg.psoft.projeto_final.servicos;

import com.ufcg.psoft.projeto_final.DTOs.FuncionarioDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface FuncionarioService {
    ResponseEntity<?> adicionaFuncionario(FuncionarioDTO funcionario);
}

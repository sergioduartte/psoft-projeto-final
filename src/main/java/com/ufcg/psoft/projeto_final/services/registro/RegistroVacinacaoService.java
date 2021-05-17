package com.ufcg.psoft.projeto_final.services.registro;

import com.ufcg.psoft.projeto_final.DTOs.RegistroVacinacaoDTO;
import com.ufcg.psoft.projeto_final.errors.RegistroInvalido;
import com.ufcg.psoft.projeto_final.models.RegistroVacinacao;
import org.springframework.stereotype.Service;

@Service
public interface RegistroVacinacaoService {
    RegistroVacinacao saveRegistro(RegistroVacinacaoDTO registroVacinacaoDTO) throws RegistroInvalido;

}

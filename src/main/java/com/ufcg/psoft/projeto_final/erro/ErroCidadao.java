package com.ufcg.psoft.projeto_final.erro;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


public class ErroCidadao {

    static final String CIDADAO_INEXISTENTE = "O cidadão de CPF %s não está cadastrado.";

    public static ResponseEntity<CustomErrorType> cidadaoInexistente(Long cpf) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(CIDADAO_INEXISTENTE, cpf)),
                HttpStatus.NOT_FOUND);
    }
}

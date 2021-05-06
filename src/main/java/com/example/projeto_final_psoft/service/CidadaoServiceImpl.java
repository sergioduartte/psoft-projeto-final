package com.example.projeto_final_psoft.service;

import com.example.projeto_final_psoft.entidades.*;
import com.example.projeto_final_psoft.repositorios.CidadaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CidadaoServiceImpl implements CidadaoService {

    @Autowired
    private CidadaoRepository cidadaoRepository;

    @Override
    public Cidadao adicionaCidadao(Cidadao cidadao) {
        Cidadao novoCidadao = new Cidadao(cidadao.getNome(), cidadao.getEndereco(), cidadao.getCpf(), cidadao.getNumeroSUS(),
                cidadao.getEmail(), cidadao.getDataNascimento().toString(), cidadao.getTelefone(), cidadao.getProfissao(), cidadao.getComorbidades().toString());
        cidadaoRepository.save(cidadao);

        return novoCidadao;
    }

    @Override
    public Optional<Cidadao> getCidadao(String cpf) {
        return cidadaoRepository.findByCpf(cpf);
    }
}

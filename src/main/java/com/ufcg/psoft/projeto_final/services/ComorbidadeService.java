package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.entidades.Comorbidade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ComorbidadeService {
    void saveComorbidades(List<String> cormobidades);

    Set<Comorbidade> getComorbidades(List<String> cormobidades);
}

package com.ufcg.psoft.projeto_final.services;

import com.ufcg.psoft.projeto_final.entidades.Comorbidade;
import com.ufcg.psoft.projeto_final.repository.ComorbidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

@Service
public class ComorbidadeServiceImpl implements ComorbidadeService{

    @Autowired
    ComorbidadeRepository comorbidadeRepository;

    @Override
    public void saveComorbidades(List<String> comorbidades) {
        for (String comorbidade : comorbidades){
            Optional<Comorbidade> comorbidade_aux = comorbidadeRepository.findByDescricao(comorbidade);

            if (!comorbidade_aux.isPresent()){
                Comorbidade nova_comorbidade = new Comorbidade(comorbidade);
                comorbidadeRepository.save(nova_comorbidade);
            }
        }
    }

    @Override
    public Set<Comorbidade> getComorbidades(List<String> comorbidades) {
        Set aux = new TreeSet<>();
        for (String comorbidade : comorbidades){
            Optional<Comorbidade> comorbidade_aux = comorbidadeRepository.findByDescricao(comorbidade);

            if (comorbidade_aux.isPresent()){
                aux.add(comorbidade_aux.get());
            }
        }
        return aux;
    }
}

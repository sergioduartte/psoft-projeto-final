package com.ufcg.psoft.projeto_final.servicos;

import com.ufcg.psoft.projeto_final.daos.VacinaRepository;
import com.ufcg.psoft.projeto_final.entidades.Vacina;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VacinaService {
    @Autowired
    private VacinaRepository<Vacina, Long> vacinaDAO;

    public Vacina adicionaVacina(Vacina vacina) {
        return vacinaDAO.save(vacina);
    }

    public List<Vacina> getVacina() {
        return vacinaDAO.findAll();
    }

    public Optional<Vacina> getVacina(Long id) {
        return vacinaDAO.findById(id);
    }
}

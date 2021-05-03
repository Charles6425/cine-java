package com.api.cinejava.service;


import com.api.cinejava.model.FilmeModel;
import com.api.cinejava.model.SalaModel;
import com.api.cinejava.model.SessaoModel;
import com.api.cinejava.repository.SessaoRepository;
import com.api.cinejava.service.exceptions.ObjectNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessaoService {
    @Autowired
    private SessaoRepository repository;

    @Autowired
    private SalaService salaService;

    @Autowired
    private FilmeService filmeService;

    public SessaoModel findById(Integer id) {
        Optional<SessaoModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não encontrado! Id: " + id
                + ", Titulo: " + SessaoModel.class.getName()));
    }

    public List<SessaoModel> findAllBySala(Integer id_ses) {
        salaService.findById(id_ses);
        return repository.findAllByCategoria(id_ses);

    }

    public List<SessaoModel> findAll() {
        return repository.findAll();
    }


    public SessaoModel create(Integer id_cat, Integer id_filme, SessaoModel obj) {
        obj.setId(null);
        SalaModel sala = salaService.findById(id_cat);
        FilmeModel filme = filmeService.findById(id_filme);
        obj.setSalaModel(sala);
        obj.setFilmeModel(filme);
        return repository.save(obj);

    }
    public SessaoModel update(Integer id, SessaoModel obj) {
        SessaoModel newObj = findById(id);
        updateData(newObj,obj);
        return repository.save(newObj);
    }

    private void updateData(SessaoModel newObj, SessaoModel obj) {
        newObj.setData(obj.getData());
        newObj.setHora_fim(obj.getHora_fim());
        newObj.setHora_inicio(obj.getHora_inicio());
        newObj.setTipo_animacao(obj.getTipo_animacao());
        newObj.setTipo_audio(obj.getTipo_audio());
        newObj.setValor_ingresso(obj.getValor_ingresso());

    }

    public void delete(Integer id) {
        SessaoModel obj = findById(id);
        repository.delete(obj);
    }
}

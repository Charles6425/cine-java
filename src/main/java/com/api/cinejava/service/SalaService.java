package com.api.cinejava.service;

import com.api.cinejava.model.SalaModel;
import com.api.cinejava.repository.SalaRepository;
import com.api.cinejava.service.exceptions.ObjectNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {
    @Autowired
    private SalaRepository repository;

    public SalaModel findById(Integer id) {
        Optional<SalaModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptions("Objeto não encontrado Id: " + id + ", Tipo: " + SalaModel.class.getName()));
    }

    public List<SalaModel> findAll() {
        return repository.findAll();
    }
    public SalaModel create(SalaModel obj) {
        obj.setId(null);
        return repository.save(obj);
    }


}

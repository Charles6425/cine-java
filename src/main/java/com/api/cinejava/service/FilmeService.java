package com.api.cinejava.service;

import com.api.cinejava.dto.FilmeDto;
import com.api.cinejava.model.FilmeModel;
import com.api.cinejava.repository.FilmeRepository;
import com.api.cinejava.service.exceptions.DataIntegrityViolationException;
import com.api.cinejava.service.exceptions.ObjectNotFoundExceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmeService {
    @Autowired
    FilmeRepository repository;

    public FilmeModel findById(Integer id) {
        Optional<FilmeModel> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundExceptions("Filme não encontrado Id: " + id + ", Tipo: " + FilmeModel.class.getName()));
    }

    public List<FilmeModel> findAll() {
        return repository.findAll();
    }


    public FilmeModel create(FilmeModel obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public FilmeModel update(Integer id, FilmeDto objDto) {
        FilmeModel obj = findById(id);
        obj.setTitulo(objDto.getTitulo());
        obj.setImagem(objDto.getImagem());
        obj.setDescricao(objDto.getDescricao());
        obj.setTitulo(objDto.getTitulo());
        obj.setDuracao(objDto.getDuracao());
        return repository.save(obj);
    }


    public void delete(Integer id) {
        findById(id);
        try {
            repository.deleteById(id);
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("O filme não pode ser deletado, pois possui sessão associada");
        }
    }
}

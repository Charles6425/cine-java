package com.api.cinejava.service;

import com.api.cinejava.model.FilmeModel;
import com.api.cinejava.model.SalaModel;
import com.api.cinejava.repository.FilmeRepository;
import com.api.cinejava.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService  {
    @Autowired
    private SalaRepository salaRepository;
    @Autowired
    private FilmeRepository filmeRepository;

    public void instanciaBancoDeDados() {
        SalaModel sala1 = new SalaModel(null, "Sala 1", 40);
        SalaModel sala2 = new SalaModel(null, "Sala 2", 50);
        SalaModel sala3 = new SalaModel(null, "Sala 3", 60);

        FilmeModel filme1 = new FilmeModel(null,"","Titanic","Filme","2:00");
        FilmeModel filme2 = new FilmeModel(null,"","Duro de morrer","Barco afundando","1:00");

        salaRepository.saveAll(Arrays.asList(sala1, sala2, sala3));
        filmeRepository.saveAll(Arrays.asList(filme1,filme2));
    }


}

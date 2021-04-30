package com.api.cinejava.dto;

import com.api.cinejava.model.SalaModel;

import java.io.Serializable;

public class SalaDto implements Serializable {

    private Integer id;
    private String nome;
    private Integer qt_assentos;

    public SalaDto(){
        super();
    }

    public SalaDto(SalaModel obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.qt_assentos = obj.getQt_assentos();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQt_assentos() {
        return qt_assentos;
    }

    public void setQt_assentos(Integer qt_assentos) {
        this.qt_assentos = qt_assentos;
    }
}

package com.api.cinejava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sala")
public class SalaModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;
    private Integer qt_assentos;


    @OneToMany(mappedBy = "salaModel")
    private List<SessaoModel> sessao = new ArrayList<>();

    public SalaModel(){
        super();
    }

    public SalaModel(Integer id, String nome, Integer qt_assentos) {
        this.id = id;
        this.nome = nome;
        this.qt_assentos = qt_assentos;
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

    public List<SessaoModel> getSessao() {
        return sessao;
    }

    public void setSessao(List<SessaoModel> sessao) {
        this.sessao = sessao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SalaModel that = (SalaModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

package com.api.cinejava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "filme")
public class FilmeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imagem;
    private String titulo;
    private String descricao;
    private String duracao;


    @OneToMany(mappedBy = "filmeModel")
    private List<SessaoModel> sessao = new ArrayList<>();


    public FilmeModel() {
        super();
    }

    public FilmeModel(Integer id, String imagem, String titulo, String descricao, String duracao) {
        this.id = id;
        this.imagem = imagem;
        this.titulo = titulo;
        this.descricao = descricao;
        this.duracao = duracao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
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

        FilmeModel that = (FilmeModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

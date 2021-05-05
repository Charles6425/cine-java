package com.api.cinejava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "filme")
public class FilmeModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String imagem;
    @NotEmpty(message = "O campo Título é requerido!")
    @Length(min = 3, max = 150, message = "O campo Título deve conter entre 3 e 150 caracteres!")
    private String titulo;
    @NotEmpty(message = "O campo Descrição é requerido!")
    @Length(min = 10, max = 2000000, message = "O campo Descriçao deve conter entre 10 e 2000000 caracteres!")
    private String descricao;
    @NotEmpty(message = "O campo Duração é requerido!")
    @Length(min = 4, max = 5, message = "O campo Duração deve conter 5 caracteres!")
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

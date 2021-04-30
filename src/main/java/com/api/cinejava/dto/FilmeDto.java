package com.api.cinejava.dto;

import com.api.cinejava.model.FilmeModel;

import java.io.Serializable;

public class FilmeDto implements Serializable {

    private Integer id;
    private String imagem;
    private String titulo;
    private String descricao;
    private String duracao;

    public FilmeDto() {
        super();
    }

    public FilmeDto(FilmeModel obj) {
        this.id = obj.getId();
        this.imagem = obj.getImagem();
        this.titulo = obj.getTitulo();
        this.descricao = obj.getDescricao();
        this.duracao = obj.getDuracao();
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
}

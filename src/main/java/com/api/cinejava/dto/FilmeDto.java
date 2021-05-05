package com.api.cinejava.dto;

import com.api.cinejava.model.FilmeModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class FilmeDto implements Serializable {

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

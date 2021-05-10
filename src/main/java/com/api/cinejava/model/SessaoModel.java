package com.api.cinejava.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity(name= "sessao")
public class SessaoModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "O campo Data é requerido!")
    @Length(min = 10, max = 10, message = "O campo Data deve conter 10 caracteres!")
    private String data;
    @NotEmpty(message = "O campo Início é requerido!")
    @Length(min = 4, max = 5, message = "O campo Início deve conter 5 caracteres!")
    private String hora_inicio;
    private String hora_fim;

    private Float valor_ingresso;
    @NotEmpty(message = "O campo Tipo de Animação é requerido!")
    private String tipo_animacao;
    @NotEmpty(message = "O campo Tipo de Áudio é requerido!")
    private String tipo_audio;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_sala")
    private SalaModel salaModel;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_filme")
    private FilmeModel filmeModel;

    public SessaoModel(){
        super();
    }

    public SessaoModel(Integer id, String data, String hora_inicio, String hora_fim, Float valor_ingresso, String tipo_animacao, String tipo_audio, SalaModel salaModel, FilmeModel filmeModel) {
        this.id = id;
        this.data = data;
        this.hora_inicio = hora_inicio;
        this.hora_fim = hora_fim;
        this.valor_ingresso = valor_ingresso;
        this.tipo_animacao = tipo_animacao;
        this.tipo_audio = tipo_audio;
        this.salaModel = salaModel;
        this.filmeModel = filmeModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public String getHora_fim() {
        return hora_fim;
    }

    public void setHora_fim(String hora_fim) {
        this.hora_fim = hora_fim;
    }

    public Float getValor_ingresso() {
        return valor_ingresso;
    }

    public void setValor_ingresso(Float valor_ingresso) {
        this.valor_ingresso = valor_ingresso;
    }

    public String getTipo_animacao() {
        return tipo_animacao;
    }

    public void setTipo_animacao(String tipo_animacao) {
        this.tipo_animacao = tipo_animacao;
    }

    public String getTipo_audio() {
        return tipo_audio;
    }

    public void setTipo_audio(String tipo_audio) {
        this.tipo_audio = tipo_audio;
    }

    public SalaModel getSalaModel() {
        return salaModel;
    }

    public void setSalaModel(SalaModel salaModel) {
        this.salaModel = salaModel;
    }

    public FilmeModel getFilmeModel() {
        return filmeModel;
    }

    public void setFilmeModel(FilmeModel filmeModel) {
        this.filmeModel = filmeModel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SessaoModel that = (SessaoModel) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

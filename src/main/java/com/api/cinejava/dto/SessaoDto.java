package com.api.cinejava.dto;

import com.api.cinejava.model.SessaoModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

public class SessaoDto implements Serializable {

    private Integer id;
    @NotEmpty(message = "O campo Data é requerido!")
    @Length(min = 10, max = 10, message = "O campo Data deve conter 10 caracteres!")
    private String data;
    @NotEmpty(message = "O campo Início é requerido!")
    @Length(min = 4, max = 5, message = "O campo Início deve conter 5 caracteres!")
    private String hora_inicio;
    private String hora_fim;
    @NotEmpty(message = "O campo Valor é requerido!")
    private Float valor_ingresso;
    @NotEmpty(message = "O campo Tipo de Animação é requerido!")
    private String tipo_animacao;
    @NotEmpty(message = "O campo Tipo de Áudio é requerido!")
    private String tipo_audio;

    public SessaoDto(){
        super();
    }

    public SessaoDto(SessaoModel obj) {
        this.id = obj.getId();
        this.data = obj.getData();
        this.hora_inicio = obj.getHora_inicio();
        this.hora_fim = obj.getHora_fim();
        this.valor_ingresso = obj.getValor_ingresso();
        this.tipo_animacao = obj.getTipo_animacao();
        this.tipo_audio = obj.getTipo_audio();
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
}

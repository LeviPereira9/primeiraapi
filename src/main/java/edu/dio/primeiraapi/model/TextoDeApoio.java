package edu.dio.primeiraapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_textoDeApoio")
public class TextoDeApoio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    private boolean temImagem;
    private String texto;
    private String fonte;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao_textoDeApoio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isTemImagem() {
        return temImagem;
    }

    public void setTemImagem(boolean temImagem) {
        this.temImagem = temImagem;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public void setQuestao_textoDeApoio(Questao questao_textoDeApoio) {
        this.questao_textoDeApoio = questao_textoDeApoio;
    }

    public Questao getQuestao_textoDeApoio() {
        return questao_textoDeApoio;
    }
}

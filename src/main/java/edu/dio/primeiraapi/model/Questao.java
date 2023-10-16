package edu.dio.primeiraapi.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity(name = "tb_questao")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int numero;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TextoDeApoio> textosDeApoio;
    private String enunciado;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private EnunciadoAssercoes enunciadoAssercoes;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Opcoes opcoes;
    private String opcao_cooreta;

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public EnunciadoAssercoes getEnunciadoAssercoes() {
        return enunciadoAssercoes;
    }

    public void setEnunciadoAssercoes(EnunciadoAssercoes enunciadoAssercoes) {
        this.enunciadoAssercoes = enunciadoAssercoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpcao_cooreta() {
        return opcao_cooreta;
    }

    public void setOpcao_cooreta(String opcao_cooreta) {
        this.opcao_cooreta = opcao_cooreta;
    }

    public Opcoes getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(Opcoes opcoes) {
        this.opcoes = opcoes;
    }

    public List<TextoDeApoio> getTextosDeApoio() {
        return textosDeApoio;
    }

    public void setTextosDeApoio(List<TextoDeApoio> textosDeApoio) {
        this.textosDeApoio = textosDeApoio;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}

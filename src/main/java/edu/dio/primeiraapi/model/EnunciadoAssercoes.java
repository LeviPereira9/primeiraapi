package edu.dio.primeiraapi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_enunciadoAssercoes")
public class EnunciadoAssercoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean temAssercao;
    private Relacao relacao;
    private List<Assercao> assercoes;
    private String posAssercoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Assercao> getAssercoes() {
        return assercoes;
    }

    public void setAssercoes(List<Assercao> assercoes) {
        this.assercoes = assercoes;
    }

    public String getPosAssercoes() {
        return posAssercoes;
    }

    public void setPosAssercoes(String posAssercoes) {
        this.posAssercoes = posAssercoes;
    }

    public Relacao getRelacao() {
        return relacao;
    }

    public void setRelacao(Relacao relacao) {
        this.relacao = relacao;
    }

    public boolean isTemAssercao() {
        return temAssercao;
    }

    public void setTemAssercao(boolean temAssercao) {
        this.temAssercao = temAssercao;
    }
}

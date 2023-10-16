package edu.dio.primeiraapi.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_enunciadoAssercoes")
public class EnunciadoAssercoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean temAssercao;
    private String posAssercoes;
    @OneToMany(mappedBy = "enunciadoAssercoes")
    private List<Assercao> assercoes;
    @OneToOne(mappedBy = "enunciadoAssercoes")
    private Relacao relacao;

    @OneToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;

    public Integer getId() {
        return id;
    }

    public boolean isTemAssercao() {
        return temAssercao;
    }

    public void setTemAssercao(boolean temAssercao) {
        this.temAssercao = temAssercao;
    }

    public String getPosAssercoes() {
        return posAssercoes;
    }

    public void setPosAssercoes(String posAssercoes) {
        this.posAssercoes = posAssercoes;
    }

}

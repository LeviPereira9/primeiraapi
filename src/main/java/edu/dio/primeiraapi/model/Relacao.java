package edu.dio.primeiraapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_relacao")
public class Relacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private boolean temRelacao;
    private String texto;

    @OneToOne
    @JoinColumn(name = "enunciadoAssercoes_id")
    private EnunciadoAssercoes enunciadoAssercoes;

    public String getTexto() {
        return texto;
    }

    public boolean isTemRelacao() {
        return temRelacao;
    }

    public void setTemRelacao(boolean temRelacao) {
        this.temRelacao = temRelacao;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}

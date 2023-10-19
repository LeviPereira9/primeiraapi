package edu.dio.primeiraapi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_questao")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String enunciado;
    private String opcao__correta;
    @OneToMany(mappedBy = "questao_textoDeApoio")
    private List<TextoDeApoio> textosDeApoio;
    @OneToOne(mappedBy = "questao_assercoes")
    private EnunciadoAssercoes enunciadoAssercoes;
    @OneToOne(mappedBy = "questao_opcoes")
    private Opcoes opcoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getOpcao__correta() {
        return opcao__correta;
    }

    public void setOpcao__correta(String opcao__correta) {
        this.opcao__correta = opcao__correta;
    }

    public List<TextoDeApoio> getTextosDeApoio() {
        return textosDeApoio;
    }

    public void setTextosDeApoio(List<TextoDeApoio> textosDeApoio) {
        this.textosDeApoio = textosDeApoio;
    }

    public EnunciadoAssercoes getEnunciadoAssercoes() {
        return enunciadoAssercoes;
    }

    public void setEnunciadoAssercoes(EnunciadoAssercoes enunciadoAssercoes) {
        this.enunciadoAssercoes = enunciadoAssercoes;
    }

    public Opcoes getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(Opcoes opcoes) {
        this.opcoes = opcoes;
    }

    @Override
    public String toString() {
        return "Questao{" +
                "id=" + id +
                ", enunciado='" + enunciado + '\'' +
                ", opcao_correta='" + opcao__correta + '\'' +
                ", textosDeApoio=" + textosDeApoio +
                ", enunciadoAssercoes=" + enunciadoAssercoes +
                ", opcoes=" + opcoes +
                '}';
    }

}

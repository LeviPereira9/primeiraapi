package edu.dio.primeiraapi.model;

import java.util.List;

import jakarta.persistence.Entity;

@Entity(name = "tb_opcoes")
public class Opcoes {
    private boolean temImagem;
    private List<Opcao> opcoes;

    public List<Opcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Opcao> opcoes) {
        this.opcoes = opcoes;
    }

    public boolean isTemImagem() {
        return temImagem;
    }

    public void setTemImagem(boolean temImagem) {
        this.temImagem = temImagem;
    }
}

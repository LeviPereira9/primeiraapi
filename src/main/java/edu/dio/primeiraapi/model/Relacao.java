package edu.dio.primeiraapi.model;

public class Relacao {

    private boolean temRelacao;
    private String texto;

    public String getTexto() {
        return texto;
    }

    public boolean isTemRelacao() {
        return temRelacao;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setTemRelacao(boolean temRelacao) {
        this.temRelacao = temRelacao;
    }

}

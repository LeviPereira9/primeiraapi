package edu.dio.primeiraapi.dto;

import edu.dio.primeiraapi.model.TextoDeApoio;

public record TextoDeApoioDto(Long id, int numero, boolean temImagem, String texto, String fonte) {

    public TextoDeApoioDto(TextoDeApoio model) {
        this(
                model.getId(),
                model.getNumero(),
                model.isTemImagem(),
                model.getTexto(),
                model.getFonte());
    }

    public TextoDeApoio toModel() {
        TextoDeApoio model = new TextoDeApoio();

        model.setId(this.id);
        model.setNumero(this.numero);
        model.setTemImagem(this.temImagem);
        model.setTexto(this.texto);
        model.setFonte(this.fonte);

        return model;
    }
}

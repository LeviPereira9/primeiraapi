package edu.dio.primeiraapi.dto;

import edu.dio.primeiraapi.model.Relacao;

public record RelacaoDto(Long id, boolean temRelacao, String texto) {

    public RelacaoDto(Relacao model) {
        this(model.getId(), model.isTemRelacao(), model.getTexto());
    }

    public Relacao toModel() {
        Relacao model = new Relacao();
        model.setId(this.id);
        model.setTemRelacao(this.temRelacao);
        model.setTexto(this.texto);

        return model;
    }
}

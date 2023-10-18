package edu.dio.primeiraapi.dto;

import edu.dio.primeiraapi.model.Assercao;

public record AssercaoDto(Long id, String numero_romano, String texto) {

    public AssercaoDto(Assercao model) {
        this(model.getId(), model.getNumero_romano(), model.getTexto());
    }

    public Assercao toModel() {
        Assercao model = new Assercao();
        model.setId(this.id);
        model.setNumero_romano(this.numero_romano);
        model.setTexto(this.texto);

        return model;
    }
}
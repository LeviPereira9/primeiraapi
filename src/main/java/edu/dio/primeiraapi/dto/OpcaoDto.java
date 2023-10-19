package edu.dio.primeiraapi.dto;

import edu.dio.primeiraapi.model.Opcao;

public record OpcaoDto(Long id, String letra, String texto) {

    public OpcaoDto(Opcao model) {
        this(model.getId(), model.getLetra(), model.getTexto());
    }

    public Opcao toModel() {
        Opcao model = new Opcao();
        model.setId(this.id);
        model.setLetra(this.letra);
        model.setTexto(this.texto);

        return model;
    }

}

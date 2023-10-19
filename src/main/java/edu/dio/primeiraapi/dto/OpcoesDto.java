package edu.dio.primeiraapi.dto;

import java.util.List;

import edu.dio.primeiraapi.model.Opcoes;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record OpcoesDto(Long id, boolean temImagem, List<OpcaoDto> opcoes) {

    public OpcoesDto(Opcoes model) {
        this(model.getId(), model.isTemImagem(),
                ofNullable(model.getOpcoes()).orElse(emptyList()).stream().map((opcao) -> new OpcaoDto(opcao))
                        .collect(toList()));
    }

    public Opcoes toModel() {
        Opcoes model = new Opcoes();

        model.setId(this.id);
        model.setTemImagem(this.temImagem);
        model.setOpcoes(ofNullable(this.opcoes).orElse(emptyList()).stream().map((opcaoDto) -> opcaoDto.toModel())
                .collect(toList()));

        return model;
    }

}

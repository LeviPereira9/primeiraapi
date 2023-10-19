package edu.dio.primeiraapi.dto;

import java.util.List;

import edu.dio.primeiraapi.model.Questao;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record QuestaoDto(Long id, String enunciado, String opcao__correta, List<TextoDeApoioDto> textosDeApoio,
        EnunciadoAssercoesDto enunciadoAssercoes, OpcoesDto opcoes) {

    public QuestaoDto(Questao model) {
        this(model.getId(), model.getEnunciado(), model.getOpcao__correta(),
                ofNullable(model.getTextosDeApoio()).orElse(emptyList()).stream()
                        .map((textoDeApoio) -> new TextoDeApoioDto(textoDeApoio)).collect(toList()),
                ofNullable(model.getEnunciadoAssercoes())
                        .map((enunciadoAssercao) -> new EnunciadoAssercoesDto(enunciadoAssercao)).orElse(null),
                ofNullable(model.getOpcoes()).map((opcoes) -> new OpcoesDto(opcoes)).orElse(null));
    }

    public Questao toModel() {
        Questao model = new Questao();

        model.setId(this.id);
        model.setEnunciado(this.enunciado);
        model.setOpcao__correta(this.opcao__correta);
        model.setTextosDeApoio(ofNullable(this.textosDeApoio).orElse(emptyList()).stream()
                .map((textoDeApoioDto) -> textoDeApoioDto.toModel()).collect(toList()));
        model.setOpcoes(ofNullable(this.opcoes).map((opcaoDto) -> opcaoDto.toModel()).orElse(null));

        return model;
    }

}

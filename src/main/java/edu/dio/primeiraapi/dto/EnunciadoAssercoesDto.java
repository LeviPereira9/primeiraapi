package edu.dio.primeiraapi.dto;

import java.util.List;

import edu.dio.primeiraapi.model.EnunciadoAssercoes;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

public record EnunciadoAssercoesDto(Long id, boolean temAssercao, String posAssercoes, List<AssercaoDto> assercoes,
                RelacaoDto relacao) {

        public EnunciadoAssercoesDto(EnunciadoAssercoes model) {
                this(
                                model.getId(),
                                model.isTemAssercao(),
                                model.getPosAssercoes(),
                                ofNullable(model.getAssercoes()).orElse(emptyList()).stream()
                                                .map(AssercaoDto::new).collect(toList()),
                                ofNullable(model.getRelacao()).map(RelacaoDto::new).orElse(null));
        }

        public EnunciadoAssercoes toModel() {
                EnunciadoAssercoes model = new EnunciadoAssercoes();

                model.setId(this.id);
                model.setTemAssercao(this.temAssercao);
                model.setPosAssercoes(this.posAssercoes);
                model.setAssercoes(ofNullable(this.assercoes).orElse(emptyList()).stream()
                                .map(AssercaoDto::toModel).collect(toList()));
                model.setRelacao(ofNullable(this.relacao).map(RelacaoDto::toModel).orElse(null));

                return model;
        }

}

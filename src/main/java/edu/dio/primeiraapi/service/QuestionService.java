package edu.dio.primeiraapi.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import edu.dio.primeiraapi.model.EnunciadoAssercoes;
import edu.dio.primeiraapi.model.Opcao;
import edu.dio.primeiraapi.model.Opcoes;
import edu.dio.primeiraapi.model.Questao;
import edu.dio.primeiraapi.model.TextoDeApoio;
import edu.dio.primeiraapi.repository.EnunciadoAssercoesRepositorio;
import edu.dio.primeiraapi.repository.OpcoesRepositorio;
import edu.dio.primeiraapi.repository.QuestaoRepositorio;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class QuestionService {

    @Autowired
    private QuestaoRepositorio questaoRepositorio;

    @Autowired
    private EnunciadoAssercoesRepositorio enunciadoAssercoesRepositorio;

    @Autowired
    private OpcoesRepositorio opcoesRepositorio;

    public Questao findById(Long id) {
        return questaoRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    public List<Questao> findAll() {
        return questaoRepositorio.findAll();
    }

    public Questao createQuestion(@RequestBody Questao questaoToCreate) {
        if (questaoToCreate.getId() != null && questaoRepositorio.existsById(questaoToCreate.getId())) {
            throw new IllegalArgumentException("Ja foi criado antes");
        }

        // Salva a entidade Questao
        Questao questaoCriada = new Questao();
        questaoCriada.setEnunciado(questaoToCreate.getEnunciado());
        questaoCriada.setOpcao__correta(questaoToCreate.getOpcao__correta());

        // Salva as entidades TextoDeApoio
        for (TextoDeApoio textoDeApoio : questaoToCreate.getTextosDeApoio()) {
            textoDeApoio.setQuestao_textoDeApoio(questaoCriada);
            questaoCriada.getTextosDeApoio().add(textoDeApoio);
        }

        // Salva as entidades EnunciadoAssercoes
        EnunciadoAssercoes enunciadoAssercoes = questaoToCreate.getEnunciadoAssercoes();
        enunciadoAssercoes.setQuestao_assercoes(questaoCriada);
        enunciadoAssercoesRepositorio.save(enunciadoAssercoes);

        // Salva as entidades Opcoes
        Opcoes opcoes = questaoToCreate.getOpcoes();
        opcoes.setQuestao_opcoes(questaoCriada);
        opcoesRepositorio.save(opcoes);

        return questaoRepositorio.save(questaoCriada);
    }

}

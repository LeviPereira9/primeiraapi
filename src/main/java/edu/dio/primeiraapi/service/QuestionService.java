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
import edu.dio.primeiraapi.repository.QuestaoRepositorio;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class QuestionService {

    @Autowired
    private QuestaoRepositorio questaoRepositorio;

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

        return questaoRepositorio.save(questaoToCreate);
    }

}

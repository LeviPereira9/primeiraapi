package edu.dio.primeiraapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.dio.primeiraapi.model.Questao;
import edu.dio.primeiraapi.repository.QuestaoRepositorio;
import edu.dio.primeiraapi.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class UserServiceImpl implements UserService {

    private final QuestaoRepositorio questaoRepositorio;

    public UserServiceImpl(QuestaoRepositorio questaoRepositorio) {
        this.questaoRepositorio = questaoRepositorio;
    }

    @Override
    public Questao findById(Long id) {
        return questaoRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Questao> findAll() {
        return questaoRepositorio.findAll();
    }

    @Override
    public Questao createQuestion(@RequestBody Questao questaoToCreate) {
        if (questaoToCreate.getId() != null && questaoRepositorio.existsById(questaoToCreate.getId())) {
            throw new IllegalArgumentException("Ja foi criado antes");
        }

        return questaoRepositorio.save(questaoToCreate);
    }

}

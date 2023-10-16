package edu.dio.primeiraapi.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import edu.dio.primeiraapi.model.Questao;
import edu.dio.primeiraapi.repository.QuestaoRepositorio;
import edu.dio.primeiraapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final QuestaoRepositorio questaoRepositorio;

    public UserServiceImpl(QuestaoRepositorio questaoRepositorio) {
        this.questaoRepositorio = questaoRepositorio;
    }

    @Override
    public Questao findById(Integer id) {
        return questaoRepositorio.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Questao> findAll() {
        return null;
    }

    @Override
    public Questao createQuestion(Questao questao) {
        return questaoRepositorio.save(questao);
    }

}

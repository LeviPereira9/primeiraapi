package edu.dio.primeiraapi.service;

import java.util.List;

import edu.dio.primeiraapi.model.Questao;

public interface UserService {
    Questao findById(Integer id);

    List<Questao> findAll();

    Questao createQuestion(Questao questao);
}

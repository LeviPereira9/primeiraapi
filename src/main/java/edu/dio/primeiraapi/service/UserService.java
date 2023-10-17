package edu.dio.primeiraapi.service;

import java.util.List;

import edu.dio.primeiraapi.model.Questao;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

public interface UserService {
    Questao findById(Long id);

    List<Questao> findAll();

    Questao createQuestion(@RequestBody Questao questao);
}

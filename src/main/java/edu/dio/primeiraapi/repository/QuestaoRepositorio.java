package edu.dio.primeiraapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.dio.primeiraapi.model.Questao;

@Repository
public interface QuestaoRepositorio extends JpaRepository<Questao, Integer> {

}

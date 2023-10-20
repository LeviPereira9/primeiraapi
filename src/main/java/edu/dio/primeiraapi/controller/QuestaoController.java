package edu.dio.primeiraapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.dio.primeiraapi.model.Questao;
import edu.dio.primeiraapi.service.QuestionService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class QuestaoController {

    /*
     * @Autowired
     * private QuestionService questionService;
     * 
     * @GetMapping("/questao/{id}")
     * public ResponseEntity<Questao> findById(@PathVariable Long id) {
     * var questao = questionService.findById(id);
     * 
     * return ResponseEntity.ok(questao);
     * }
     * 
     * @GetMapping("/questoes")
     * public ResponseEntity<List<Questao>> findAll() {
     * List<Questao> questao = questionService.findAll();
     * 
     * return ResponseEntity.ok(questao);
     * }
     * 
     * @PostMapping
     * public ResponseEntity<Questao> create(@RequestBody Questao questao) {
     * var questaoCriada = questionService.createQuestion(questao);
     * URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
     * .buildAndExpand(questaoCriada.getId()).toUri();
     * return ResponseEntity.created(location).body(questaoCriada);
     * }
     */
}

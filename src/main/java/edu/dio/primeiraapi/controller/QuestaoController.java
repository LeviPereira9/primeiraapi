package edu.dio.primeiraapi.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.dio.primeiraapi.model.Questao;
import edu.dio.primeiraapi.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/questoes")
public class QuestaoController {

    private final UserService userService;

    public QuestaoController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Questao> findById(@PathVariable Integer id) {
        var questao = userService.findById(id);

        return ResponseEntity.ok(questao);
    }

    @GetMapping("/questoes")
    public ResponseEntity<List<Questao>> findAll() {
        var questao = userService.findAll();

        return ResponseEntity.ok(questao);
    }

    @PostMapping
    public ResponseEntity<Questao> create(@RequestBody Questao questao) {
        var questaoCriada = userService.createQuestion(questao);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(questaoCriada.getId()).toUri();
        return ResponseEntity.created(location).body(questaoCriada);
    }
}

package edu.dio.primeiraapi.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.dio.primeiraapi.dto.QuestaoDto;
import edu.dio.primeiraapi.service.QuestionService;
import edu.dio.primeiraapi.service.impl.QuestionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@CrossOrigin
@RestController
@RequestMapping("/questoes")
@Tag(name = "Questoes Controller", description = "Uma API para gerenciar as questões do Enade.")
public record QuestaoController(QuestionService questionService) {

    @GetMapping
    @Operation(summary = "Buscar todas as questões", description = "Retorna uma lista com todas as questões disponíveis")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful")
    })
    public ResponseEntity<List<QuestaoDto>> findAll() {
        var questoes = questionService.findAll();
        var questoesDto = questoes.stream().map(QuestaoDto::new).collect(Collectors.toList());
        return ResponseEntity.ok(questoesDto);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar apenas uma questão", description = "Retorna uma unica questão baseada em seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Question not found")
    })
    public ResponseEntity<QuestaoDto> findById(@PathVariable Long id) {
        var questao = questionService.findById(id);
        return ResponseEntity.ok(new QuestaoDto(questao));
    }

    @PostMapping
    @Operation(summary = "Adicionar uma questão", description = "Adicione uma nova questão e receba os dados que foram inseridos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "422", description = "Invalid question data provided")
    })
    public ResponseEntity<QuestaoDto> create(@RequestBody QuestaoDto questaoDto) {
        var questao = questionService.create(questaoDto.toModel());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(questao.getId())
                .toUri();

        return ResponseEntity.created(location).body(new QuestaoDto(questao));
    }
}

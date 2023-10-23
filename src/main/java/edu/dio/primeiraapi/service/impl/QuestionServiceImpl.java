package edu.dio.primeiraapi.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.dio.primeiraapi.model.Questao;
import edu.dio.primeiraapi.repository.QuestaoRepositorio;
import edu.dio.primeiraapi.service.QuestionService;
import edu.dio.primeiraapi.service.exceptions.BusinessException;
import edu.dio.primeiraapi.service.exceptions.NotFoundException;
import jakarta.transaction.Transactional;

import static java.util.Optional.ofNullable;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestaoRepositorio questaoRepositorio;

    public QuestionServiceImpl(QuestaoRepositorio questaoRepositorio) {
        this.questaoRepositorio = questaoRepositorio;
    }

    @Transactional
    public List<Questao> findAll() {
        return this.questaoRepositorio.findAll();
    }

    @Transactional
    public Questao findById(Long id) {
        return this.questaoRepositorio.findById(id).orElseThrow(NotFoundException::new);
    }

    @Transactional
    public Questao create(Questao questaoParaCriar) {

        ofNullable(questaoParaCriar)
                .orElseThrow(() -> new BusinessException("A questão a ser criado não pode estar vazia."));
        // Mais regras de negócio.

        return this.questaoRepositorio.save(questaoParaCriar);
    }

    @Transactional
    public Questao update(Long id, Questao questaoParaAlterar) {

        Questao dbQuestao = this.findById(id);

        if (!dbQuestao.getId().equals(questaoParaAlterar.getId())) {
            throw new BusinessException("A questão para alterar precisa ter o mesmo Id fornecido.");
        }

        dbQuestao.setEnunciado(questaoParaAlterar.getEnunciado());
        dbQuestao.setOpcao__correta(questaoParaAlterar.getOpcao__correta());
        dbQuestao.setTextosDeApoio(questaoParaAlterar.getTextosDeApoio());
        dbQuestao.setEnunciadoAssercoes(questaoParaAlterar.getEnunciadoAssercoes());
        dbQuestao.setOpcoes(questaoParaAlterar.getOpcoes());

        return this.questaoRepositorio.save(dbQuestao);
    }

    @Transactional
    public void delete(Long id) {
        Questao dbQuestao = this.findById(id);
        this.questaoRepositorio.delete(dbQuestao);
    }

}

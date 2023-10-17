package edu.dio.primeiraapi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_opcoes")
public class Opcoes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean temImagem;
    @OneToMany(mappedBy = "opcoes_opcao")
    private List<Opcao> opcoes;

    @OneToOne
    @JoinColumn(name = "questao_id")
    private Questao questao_opcoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isTemImagem() {
        return temImagem;
    }

    public void setTemImagem(boolean temImagem) {
        this.temImagem = temImagem;
    }

    public List<Opcao> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<Opcao> opcoes) {
        this.opcoes = opcoes;
    }

    public void setQuestao_opcoes(Questao questao_opcoes) {
        this.questao_opcoes = questao_opcoes;
    }

    public Questao getQuestao_opcoes() {
        return questao_opcoes;
    }
}

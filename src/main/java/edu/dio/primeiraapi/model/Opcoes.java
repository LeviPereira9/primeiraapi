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
    private Integer id;
    private boolean temImagem;
    @OneToMany(mappedBy = "opcoes")
    private List<Opcao> opcoes;

    @OneToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;
}

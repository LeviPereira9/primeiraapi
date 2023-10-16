package edu.dio.primeiraapi.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity(name = "tb_questao")
public class Questao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String enunciado;
    private String opcao__correta;
    @OneToMany(mappedBy = "questao")
    private List<TextoDeApoio> textosDeApoio;
    @OneToOne(mappedBy = "questao")
    private EnunciadoAssercoes enunciadoAssercoes;
    @OneToOne(mappedBy = "questao")
    private Opcoes opcoes;

}

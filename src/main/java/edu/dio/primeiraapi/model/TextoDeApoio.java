package edu.dio.primeiraapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "tb_textoDeApoio")
public class TextoDeApoio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private int numero;
    private boolean temImagme;
    private String texto;
    private String fonte;

    @ManyToOne
    @JoinColumn(name = "questao_id")
    private Questao questao;
}

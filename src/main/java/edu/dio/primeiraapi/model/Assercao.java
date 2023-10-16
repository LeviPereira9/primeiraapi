package edu.dio.primeiraapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_assercao")
public class Assercao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String numero_romano;
    private String texto;

    @ManyToOne
    @JoinColumn(name = "enunciadoAssercoes_id")
    private EnunciadoAssercoes enunciadoAssercoes;

    // Getters e Setters
}

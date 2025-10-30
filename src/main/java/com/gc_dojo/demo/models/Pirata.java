package com.gc_dojo.demo.models;

import com.gc_dojo.demo.enums.Raca;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pirata {
    private static int counter = 0;

    public Pirata(int id, String nome, Raca raca, String bando) {
        counter++;
        this.id = counter;
        this.nome = nome;
        this.raca = raca;
        this.bando = bando;
    }

    public Pirata(){}

    @Id
    private int id;

    private String nome;
    private Raca raca;
    private String bando;


}

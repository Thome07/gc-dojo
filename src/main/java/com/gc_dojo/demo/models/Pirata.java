package com.gc_dojo.demo.models;

import com.gc_dojo.demo.enums.Raca;
import com.gc_dojo.demo.enums.StatusPirata;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

// quero ver se faltou algo em pirata
@Entity
public class Pirata {
    private static int counter = 0;

    public Pirata(int id, String nome, Raca raca, String bando, StatusPirata statusPirata) {
        counter++;
        this.id = counter;
        this.nome = nome;
        this.raca = raca;
        this.bando = bando;
        this.statusPirata = statusPirata;
    }

    public Pirata(){}

    @Id
    private int id;

    private String nome;
    private Raca raca;
    private String bando;
    private StatusPirata statusPirata;

    @OneToMany
    private List<MissaoPirata> missions = new ArrayList<>();

    public void addMissions(MissaoPirata mission){
        missions.add(mission);
    }

}

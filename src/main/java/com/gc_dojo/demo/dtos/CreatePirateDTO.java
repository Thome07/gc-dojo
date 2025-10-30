package com.gc_dojo.demo.dtos;

import com.gc_dojo.demo.enums.Raca;
import com.gc_dojo.demo.enums.StatusPirata;

public record CreatePirateDTO(String nome, Raca raca, String bando, StatusPirata statusPirata) {
}

package com.gc_dojo.demo.models;

import com.gc_dojo.demo.enums.NivelPerigo;
import com.gc_dojo.demo.enums.StatusMissao;
import com.gc_dojo.demo.enums.TipoMissao;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class MissaoPirata {
    private static int counter = 0;

    public MissaoPirata(Integer id, NivelPerigo nivelPerigo, TipoMissao tipoMissao, StatusMissao status) {
        this.id = id;
        this.nivelPerigo = nivelPerigo;
        this.tipoMissao = tipoMissao;
        this.status = status;
    }

    public MissaoPirata(){}

    @Id
    private Integer id;

    private NivelPerigo nivelPerigo;

    private TipoMissao tipoMissao;

    private StatusMissao status;

}

package com.resistence.war.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity(name = "TB_REBELDES")
@NoArgsConstructor
@Data
public class RebeldeDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rebeldeID;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String idade;

    @Column(nullable = false)
    private String genero;

    @OneToOne
    @JoinColumn(name = "localizacaoID")
    private LocalizacaoDomain localizacaoDomain;

//    @Column(nullable = false)
//    private Inventario inventario;

    @OneToMany
    @JoinColumn(name = "rebeldeID")
    private List<RebeldeDomain> reports;

    public RebeldeDomain(String nome, String idade, String genero, LocalizacaoDomain localizacaoDomain) {
        this.nome = nome;
        this.idade = idade;
        this.genero = genero;
        this.localizacaoDomain = localizacaoDomain;
    }
}

package com.resistence.war.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "TB_LOCALIZACAO")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LocalizacaoDomain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long localizacaoID;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @Column(nullable = false)
    private String base;

    @Column(nullable = false)
    private String galaxia;

    @OneToOne
    private RebeldeDomain rebeldeDomain;

    public LocalizacaoDomain(String latitude, String longitude, String base, String galaxia) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.base = base;
        this.galaxia = galaxia;
    }
}

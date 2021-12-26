package com.resistence.war.controller.request;

import com.resistence.war.domain.LocalizacaoDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AtualizarLocalizacaoParams {

    private Long rebeldeid;
    private String latitude;
    private String longitude;
    private String base;
    private String galaxia;

    public LocalizacaoDomain toDomain(){
        return new LocalizacaoDomain(
                this.latitude,
                this.getLongitude(),
                this.base,
                this.galaxia);
    }
}

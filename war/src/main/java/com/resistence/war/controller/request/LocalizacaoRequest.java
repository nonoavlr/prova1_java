package com.resistence.war.controller.request;

import com.resistence.war.domain.LocalizacaoDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class LocalizacaoRequest {

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    @NotBlank
    private String base;

    @NotBlank
    private String galaxia;

    public LocalizacaoDomain toDomain(){
        return new LocalizacaoDomain(
                this.latitude,
                this.longitude,
                this.base,
                this.galaxia);
    }
}

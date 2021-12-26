package com.resistence.war.controller.request;

import com.resistence.war.domain.RebeldeDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Getter
public class AddRebeldeRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String idade;

    @NotBlank
    private String genero;

    @NotNull
    @Valid
    private LocalizacaoRequest localizacao;

    public RebeldeDomain toDomain(){
        return new RebeldeDomain(
                this.nome,
                this.idade,
                this.genero,
                this.localizacao.toDomain());
    }
}

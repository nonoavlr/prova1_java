package com.resistence.war.controller;

import com.resistence.war.controller.request.AtualizarLocalizacaoParams;
import com.resistence.war.domain.LocalizacaoDomain;
import com.resistence.war.domain.RebeldeDomain;
import com.resistence.war.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/localizacao")
@AllArgsConstructor
public class LocalizacaoController {

    private RebeldeRepository rebeldeRepository;

    @GetMapping("/update")
    public ResponseEntity<?> atualizarLocalizacao(@ModelAttribute AtualizarLocalizacaoParams params){

        try{
            RebeldeDomain rebeldeDomain = rebeldeRepository.findById(params.getRebeldeid()).get();
            rebeldeDomain.setLocalizacaoDomain(params.toDomain());
            rebeldeRepository.save(rebeldeDomain);

            return ResponseEntity.ok(rebeldeDomain.getLocalizacaoDomain());

        }catch (Exception e){

            return  ResponseEntity.badRequest().build();
        }

    }
}

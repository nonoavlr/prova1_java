package com.resistence.war.controller;

import com.resistence.war.controller.request.AddRebeldeRequest;
import com.resistence.war.controller.request.ReportRebeldeRequest;
import com.resistence.war.domain.LocalizacaoDomain;
import com.resistence.war.domain.RebeldeDomain;
import com.resistence.war.repository.LocalizacaoRepository;
import com.resistence.war.repository.RebeldeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/rebelde")
@AllArgsConstructor
public class RebeldeController {

    private RebeldeRepository rebeldeRepository;
    private LocalizacaoRepository localizacaoRepository;

    @PostMapping("/add")
    public ResponseEntity<?> createRebelde(@RequestBody @Valid AddRebeldeRequest addRebeldeRequest){

        try {
            RebeldeDomain newRebelde = addRebeldeRequest.toDomain();
            LocalizacaoDomain newLocalizacao = addRebeldeRequest.getLocalizacao().toDomain();

            localizacaoRepository.save(newLocalizacao);

            newRebelde.setLocalizacaoDomain(newLocalizacao);

            rebeldeRepository.save(newRebelde);

            return ResponseEntity.ok(newRebelde);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

//    @PostMapping("/report")
//    public ResponseEntity<?> reportRebelde(@RequestBody @Valid ReportRebeldeRequest reportRebeldeRequest){
//
//        try {
//            RebeldeDomain rebeldeDenunciante = rebeldeRepository.findById(reportRebeldeRequest.getRebeldeDenuncianteID()).get();
//            RebeldeDomain rebeldeDenunciado = rebeldeRepository.findById(reportRebeldeRequest.getRebeldeDenunciadoID()).get();
//
//
//
//            return ResponseEntity.ok(newRebelde);
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.badRequest().build();
//        }
//    }
}

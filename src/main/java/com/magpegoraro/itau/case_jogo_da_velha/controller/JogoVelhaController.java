package com.magpegoraro.itau.case_jogo_da_velha.controller;

import com.magpegoraro.itau.case_jogo_da_velha.model.JogoVelhaRequest;
import com.magpegoraro.itau.case_jogo_da_velha.model.JogoVelhaResponse;
import com.magpegoraro.itau.case_jogo_da_velha.service.JogoVelhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JogoVelhaController {

    @Autowired
    private JogoVelhaService jogoVelhaService;

    @PostMapping(value = "/jogovelha")
    public ResponseEntity<JogoVelhaResponse> jogar(@RequestBody final JogoVelhaRequest jogoVelhaRequest){
        if(jogoVelhaService.isVelha(jogoVelhaRequest.getJogo())){
           return ResponseEntity.badRequest().body(JogoVelhaResponse.builder().mensagem("Não tivemos um vencedor.").build());
        }
        return ResponseEntity.ok(JogoVelhaResponse.builder().mensagem("Tivemos um vencedor!").build());
    }
}

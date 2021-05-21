package com.magpegoraro.itau.case_jogo_da_velha.controller;

import com.magpegoraro.itau.case_jogo_da_velha.exception.JogoInvalidoException;
import com.magpegoraro.itau.case_jogo_da_velha.model.JogoVelhaResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController  extends ResponseEntityExceptionHandler {

    @ExceptionHandler(JogoInvalidoException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<JogoVelhaResponse> handleJogoInvalidoException(final JogoInvalidoException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(JogoVelhaResponse.builder().mensagem(exception.getMessage()).build());
    }
}

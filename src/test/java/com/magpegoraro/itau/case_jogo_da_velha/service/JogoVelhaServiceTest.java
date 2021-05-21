package com.magpegoraro.itau.case_jogo_da_velha.service;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JogoVelhaServiceTest {

    JogoVelhaService jogoVelhaService = new JogoVelhaService();


    @Test
    public void converterArrayDeStringsParaArrayDeInteiros() {
        List<String> lista = new ArrayList<>();
        lista.add("XXX");
        lista.add("XXX");
        lista.add("XXX");

//        jogoVelhaService.converterArrayDeStringsParaArrayDeInteiros(lista);
    }

}
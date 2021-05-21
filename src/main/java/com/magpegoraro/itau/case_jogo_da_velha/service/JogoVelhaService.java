package com.magpegoraro.itau.case_jogo_da_velha.service;

import com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility.JogoVelhaMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class JogoVelhaService {

    @Autowired
    private JogoVelhaMiddleware middleware;

    public boolean isVelha(final int[] jogo) {
        return middleware.check(jogo);
    }

    public boolean isVelha(final List<String> jogo) {
        if(isJogoValido(jogo)){
            throw new RuntimeException("O jogo é inválido.");
        }
        final int[] jogoInt = converterArrayDeStringsParaArrayDeInteiros(jogo);
        return isVelha(jogoInt);
    }

    private int[] converterArrayDeStringsParaArrayDeInteiros(final List<String> jogo) {
        return jogo.stream()
                        .map(linha -> Arrays.asList(linha.split("")))
                        .flatMap(Collection::stream)
                        .map(letra -> "X".equals(letra) ? 1 : 0)
                        .mapToInt(Integer::intValue).toArray();
    }

    private boolean isJogoValido(final List<String> jogo){
        final boolean jogoNaoContemTresLinhas = jogo.size() != 3;
        final boolean jogoNaoContemTresColunas = jogo.stream().anyMatch(linha -> linha.length() != 3);
        final boolean jogoPossuiLetraNaoPermitida = jogo.stream().map(linha -> Arrays.asList(linha.split(""))).flatMap(Collection::stream).anyMatch(letra -> !"XO".contains(letra));

        if(jogoNaoContemTresLinhas || jogoNaoContemTresColunas || jogoPossuiLetraNaoPermitida)
            return false;

        return true;
    }

}

package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JogoVelhaMiddlewareBean {

    @Bean
    public JogoVelhaMiddleware beanJogoVelhaMiddleware(){
        final JogoVelhaMiddleware jogoVelhaMiddleware = new GanharPrimeiraLinhaMiddleware();
        jogoVelhaMiddleware
                .linkWith(new GanharSegundaLinhaMiddleware())
                .linkWith(new GanharTerceiraLinhaMiddleware())
                .linkWith(new GanharPrimeiraColunaMiddleware())
                .linkWith(new GanharSegundaColunaMiddleware())
                .linkWith(new GanharTerceiraColunaMiddleware())
                .linkWith(new GanharPrimeiraDiagonalMiddleware())
                .linkWith(new GanharPrimeiraDiagonalMiddleware());
        return jogoVelhaMiddleware;
    }

}

package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

public class GanharSegundaLinhaMiddleware extends JogoVelhaMiddleware {
    @Override
    public boolean check(final int[] jogo) {
        if(jogo[3] == jogo[4] && jogo[4] == jogo[5])
            return false;
        return checkNext(jogo);
    }
}

package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

public class GanharSegundaDiagonalMiddleware extends JogoVelhaMiddleware {
    @Override
    public boolean check(final int[] jogo) {
        if(jogo[6] == jogo[4] && jogo[4] == jogo[2])
            return false;
        return checkNext(jogo);
    }
}

package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

public class GanharPrimeiraDiagonalMiddleware extends JogoVelhaMiddleware {
    @Override
    public boolean check(final int[] jogo) {
        if(jogo[0] == jogo[4] && jogo[4] == jogo[8])
            return false;
        return checkNext(jogo);
    }
}

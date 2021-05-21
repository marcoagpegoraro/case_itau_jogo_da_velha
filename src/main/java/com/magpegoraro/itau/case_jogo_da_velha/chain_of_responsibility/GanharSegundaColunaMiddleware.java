package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

public class GanharSegundaColunaMiddleware extends JogoVelhaMiddleware {
    @Override
    public boolean check(final int[] jogo) {
        if(jogo[1] == jogo[4] && jogo[4] == jogo[7])
            return false;
        return checkNext(jogo);
    }
}

package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

public class GanharPrimeiraColunaMiddleware extends JogoVelhaMiddleware {
    @Override
    public boolean check(final int[] jogo) {
        if(jogo[0] == jogo[3] && jogo[3] == jogo[6])
            return false;
        return checkNext(jogo);
    }
}

package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

public class GanharPrimeiraLinhaMiddleware extends JogoVelhaMiddleware {
    @Override
    public boolean check(final int[] jogo) {
        if(jogo[0] == jogo[1] && jogo[1] == jogo[2])
            return false;
        return checkNext(jogo);
    }
}

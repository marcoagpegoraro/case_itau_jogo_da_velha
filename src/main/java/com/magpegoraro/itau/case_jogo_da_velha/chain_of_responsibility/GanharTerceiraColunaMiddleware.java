package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

public class GanharTerceiraColunaMiddleware extends JogoVelhaMiddleware {
    @Override
    public boolean check(final int[] jogo) {
        if(jogo[2] == jogo[5] && jogo[5] == jogo[8])
            return false;
        return checkNext(jogo);
    }
}

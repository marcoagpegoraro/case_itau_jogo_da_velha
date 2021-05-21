package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;

public class GanharTerceiraLinhaMiddleware extends JogoVelhaMiddleware {
    @Override
    public boolean check(final int[] jogo) {
        if(jogo[6] == jogo[7] && jogo[7] == jogo[8])
            return false;
        return checkNext(jogo);
    }
}

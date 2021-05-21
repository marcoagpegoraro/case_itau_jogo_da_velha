package com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility;


public abstract class JogoVelhaMiddleware {
    private JogoVelhaMiddleware next;

    public JogoVelhaMiddleware linkWith(JogoVelhaMiddleware next) {
        this.next = next;
        return next;
    }

    public abstract boolean check(final int[] jogo);

    protected boolean checkNext(final int[] jogo) {
        if (next == null) {
            return true;
        }
        return next.check(jogo);
    }
}

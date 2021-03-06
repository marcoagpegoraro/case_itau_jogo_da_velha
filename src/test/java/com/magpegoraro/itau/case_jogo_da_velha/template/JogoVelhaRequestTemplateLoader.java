package com.magpegoraro.itau.case_jogo_da_velha.template;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;
import com.magpegoraro.itau.case_jogo_da_velha.model.JogoVelhaRequest;

import java.util.Arrays;

public class JogoVelhaRequestTemplateLoader implements TemplateLoader {

    public static final String GANHA_PRIMEIRA_LINHA = "GANHA_PRIMEIRA_LINHA";
    public static final String GANHA_SEGUNDA_LINHA = "GANHA_SEGUNDA_LINHA";
    public static final String GANHA_TERCEIRA_LINHA = "GANHA_TERCEIRA_LINHA";
    public static final String GANHA_PRIMEIRA_COLUNA = "GANHA_PRIMEIRA_COLUNA";
    public static final String GANHA_SEGUNDA_COLUNA = "GANHA_SEGUNDA_COLUNA";
    public static final String GANHA_TERCEIRA_COLUNA = "GANHA_TERCEIRA_COLUNA";
    public static final String GANHA_PRIMEIRA_DIAGONAL = "GANHA_PRIMEIRA_DIAGONAL";
    public static final String GANHA_SEGUNDA_DIAGONAL = "GANHA_SEGUNDA_DIAGONAL";

    public static final String JOGO_COM_4_LINHAS = "JOGO_COM_4_LINHAS";
    public static final String JOGO_COM_2_COLUNAS = "JOGO_COM_UMA_LETRA_DIFERENTE";
    public static final String JOGO_COM_UMA_LETRA_DIFERENTE = "JOGO_COM_UMA_LETRA_DIFERENTE";

    public static final String JOGO_SEM_VENCEDOR = "JOGO_SEM_VENCEDOR";

    @Override
    public void load() {
        Fixture.of(JogoVelhaRequest.class).addTemplate(GANHA_PRIMEIRA_LINHA, new Rule() {{
            add("jogo", Arrays.asList("XXX", "XXO", "OOX"));
        }}).addTemplate(GANHA_SEGUNDA_LINHA, new Rule() {{
            add("jogo", Arrays.asList("XOO", "XXX", "OXO"));
        }}).addTemplate(GANHA_TERCEIRA_LINHA, new Rule() {{
            add("jogo", Arrays.asList("XXO", "OOX", "XXX"));
        }}).addTemplate(GANHA_PRIMEIRA_COLUNA, new Rule() {{
            add("jogo", Arrays.asList("XXO", "XXO", "XOX"));
        }}).addTemplate(GANHA_SEGUNDA_COLUNA, new Rule() {{
            add("jogo", Arrays.asList("XXO", "OXX", "XXO"));
        }}).addTemplate(GANHA_TERCEIRA_COLUNA, new Rule() {{
            add("jogo", Arrays.asList("OXX", "OXX", "XOX"));
        }}).addTemplate(GANHA_PRIMEIRA_DIAGONAL, new Rule() {{
            add("jogo", Arrays.asList("OXX", "OOX", "XXO"));
        }}).addTemplate(GANHA_SEGUNDA_DIAGONAL, new Rule() {{
            add("jogo", Arrays.asList("XXO", "XOO", "OXX"));
        }}).addTemplate(JOGO_COM_4_LINHAS, new Rule() {{
            add("jogo", Arrays.asList("XXO", "XOO", "OXX", "OXX"));
        }}).addTemplate(JOGO_COM_2_COLUNAS, new Rule() {{
            add("jogo", Arrays.asList("XX", "XO", "OX"));
        }}).addTemplate(JOGO_COM_UMA_LETRA_DIFERENTE, new Rule() {{
            add("jogo", Arrays.asList("XXO", "XOO", "OXC"));
        }}).addTemplate(JOGO_SEM_VENCEDOR, new Rule() {{
            add("jogo", Arrays.asList("XOX", "XXO", "OXO"));
        }});
    }

}

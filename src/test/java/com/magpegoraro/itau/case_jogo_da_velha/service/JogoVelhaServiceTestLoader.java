package com.magpegoraro.itau.case_jogo_da_velha.service;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.magpegoraro.itau.case_jogo_da_velha.chain_of_responsibility.JogoVelhaMiddleware;
import com.magpegoraro.itau.case_jogo_da_velha.exception.JogoInvalidoException;
import com.magpegoraro.itau.case_jogo_da_velha.model.JogoVelhaRequest;
import com.magpegoraro.itau.case_jogo_da_velha.template.JogoVelhaRequestTemplateLoader;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class JogoVelhaServiceTestLoader {

    @InjectMocks
    @Autowired
    private JogoVelhaService jogoVelhaService;

    @Mock
    JogoVelhaMiddleware jogoVelhaMiddleware;

    @Before
    public void setup(){
        FixtureFactoryLoader.loadTemplates("com.magpegoraro.itau.case_jogo_da_velha");

    }

    @Test
    public void testarPrimeiraLinha() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_PRIMEIRA_LINHA)).getJogo();
        //when
        final boolean isVelha = jogoVelhaService.isVelha(lista);
        //then
        Assert.assertFalse(isVelha);
    }

    @Test
    public void testarSegundaLinha() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_SEGUNDA_LINHA)).getJogo();
        //when
        final boolean isVelha = jogoVelhaService.isVelha(lista);
        //then
        Assert.assertFalse(isVelha);
    }

    @Test
    public void testarTerceiraLinha() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_TERCEIRA_LINHA)).getJogo();
        //when
        final boolean isVelha = jogoVelhaService.isVelha(lista);
        //then
        Assert.assertFalse(isVelha);
    }

    @Test
    public void testarPrimeiraColuna() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_PRIMEIRA_COLUNA)).getJogo();
        //when
        final boolean isVelha = jogoVelhaService.isVelha(lista);
        //then
        Assert.assertFalse(isVelha);
    }

    @Test
    public void testarSegundaColuna() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_SEGUNDA_COLUNA)).getJogo();
        //when
        final boolean isVelha = jogoVelhaService.isVelha(lista);
        //then
        Assert.assertFalse(isVelha);
    }

    @Test
    public void testarTerceiraColuna() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_TERCEIRA_COLUNA)).getJogo();
        //when
        final boolean isVelha = jogoVelhaService.isVelha(lista);
        //then
        Assert.assertFalse(isVelha);
    }

    @Test
    public void testarPrimeiraDiagonal() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_PRIMEIRA_DIAGONAL)).getJogo();
        //when
        final boolean isVelha = jogoVelhaService.isVelha(lista);
        //then
        Assert.assertFalse(isVelha);
    }

    @Test
    public void testarSegundaDiagonal() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_SEGUNDA_DIAGONAL)).getJogo();
        //when
        final boolean isVelha = jogoVelhaService.isVelha(lista);
        //then
        Assert.assertFalse(isVelha);
    }

    @Test(expected = JogoInvalidoException.class)
    public void jogoInvalido4Linhas() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.JOGO_COM_4_LINHAS)).getJogo();
        //when
        jogoVelhaService.isVelha(lista);
    }

    @Test(expected = JogoInvalidoException.class)
    public void jogoInvalido2Colunas() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.JOGO_COM_2_COLUNAS)).getJogo();
        //when
        jogoVelhaService.isVelha(lista);
    }

    @Test(expected = JogoInvalidoException.class)
    public void jogoInvalidoLetraDiferente() {
        // given
        final List<String> lista = ((JogoVelhaRequest) Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.JOGO_COM_UMA_LETRA_DIFERENTE)).getJogo();
        //when
        jogoVelhaService.isVelha(lista);
    }



}
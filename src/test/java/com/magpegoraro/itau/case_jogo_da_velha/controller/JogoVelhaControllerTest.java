package com.magpegoraro.itau.case_jogo_da_velha.controller;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader;
import com.google.gson.Gson;
import com.magpegoraro.itau.case_jogo_da_velha.exception.JogoInvalidoException;
import com.magpegoraro.itau.case_jogo_da_velha.model.JogoVelhaRequest;
import com.magpegoraro.itau.case_jogo_da_velha.service.JogoVelhaService;
import com.magpegoraro.itau.case_jogo_da_velha.template.JogoVelhaRequestTemplateLoader;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(JogoVelhaController.class)
public class JogoVelhaControllerTest {

    @MockBean
    JogoVelhaService jogoVelhaService;

    @Autowired
    private MockMvc mvc;

    @Before
    public void setUp() {
        FixtureFactoryLoader.loadTemplates("com.magpegoraro.itau.case_jogo_da_velha");
    }

    @Test
    public void deveRetornar200PoisTemosUmVencedor() throws Exception {
        final JogoVelhaRequest jogo =  Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.GANHA_PRIMEIRA_LINHA);

        Mockito.when(jogoVelhaService.isVelha(Mockito.anyList())).thenReturn(false);

        mvc.perform( MockMvcRequestBuilders
                .post("/jogovelha")
                .content(new Gson().toJson(jogo))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").exists());
    }

    @Test
    public void deveRetornar404PoisNaoTemosUmVencedor() throws Exception {
        final JogoVelhaRequest jogo =  Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.JOGO_SEM_VENCEDOR);

        Mockito.when(jogoVelhaService.isVelha(Mockito.anyList())).thenReturn(true);

        mvc.perform( MockMvcRequestBuilders
                .post("/jogovelha")
                .content(new Gson().toJson(jogo))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").exists());
    }

    @Test
    public void deveRetornar400PoisOJogoEInvalido() throws Exception {
        final JogoVelhaRequest jogo =  Fixture.from(JogoVelhaRequest.class).gimme(JogoVelhaRequestTemplateLoader.JOGO_COM_2_COLUNAS);

        Mockito.when(jogoVelhaService.isVelha(Mockito.anyList())).thenThrow(new JogoInvalidoException("Jogo Inválido."));

        mvc.perform( MockMvcRequestBuilders
                .post("/jogovelha")
                .content(new Gson().toJson(jogo))
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.mensagem").exists());
    }

}
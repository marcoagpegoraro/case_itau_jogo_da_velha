package com.magpegoraro.itau.case_jogo_da_velha.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder
@Data
public class JogoVelhaResponse {
    private String mensagem;
}

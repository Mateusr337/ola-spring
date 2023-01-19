package com.ola.spring.app.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CarDto {

    @NotBlank(message = "[modelo] must not be blank")
    private String modelo;

    @NotBlank(message = "[fabricante] must not be blank")
    private String fabricante;

    @NotBlank(message = "[dataFabricação] must not be blank")
    private String dataFabricacao;

    @NotBlank(message = "[valor] must not be blank")
    private String valor;

    @NotBlank(message = "[anoModelo] must not be blank")
    private String anoModelo;
}

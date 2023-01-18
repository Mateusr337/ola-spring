package com.ola.spring.app.dto;

import lombok.Data;

@Data
public class CarDto {
    private String modelo;
    private String fabricante;
    private String dataFabricacao;
    private String valor;
    private String anoModelo;
}

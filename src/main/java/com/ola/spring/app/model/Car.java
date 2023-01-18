package com.ola.spring.app.model;


import com.ola.spring.app.dto.CarDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Car {

    public Car (CarDto carDto) {
        this.modelo = carDto.getModelo();
        this.fabricante = carDto.getFabricante();
        this.dataFabricacao = carDto.getDataFabricacao();
        this.valor = carDto.getValor();
        this.anoModelo = carDto.getAnoModelo();
    }

    @Id
    @GeneratedValue
    private Long id;

    @Column (nullable = false)
    private String modelo;

    @Column (nullable = false)
    private String fabricante;

    @Column (nullable = false)
    private String dataFabricacao;

    @Column (nullable = false)
    private String valor;

    @Column (nullable = false)
    private String anoModelo;
}

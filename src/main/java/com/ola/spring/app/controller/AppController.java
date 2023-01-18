package com.ola.spring.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ola.spring.app.dto.CarDto;
import com.ola.spring.app.model.Car;
import com.ola.spring.app.repository.AppRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    private AppRepository repository;
    
    @GetMapping
    public String getHello () {
        return "Olá Spring";
    }

    @GetMapping("/cars")
    public List<Car> getCars () {
        return repository.findAll();
    }

    @PostMapping
    public Car post (@RequestBody CarDto carDto) {
        log.info("Received car: {}", carDto.getModelo());
        log.info("Saiving car: {} ...", carDto.getModelo());
        Car car = new Car(carDto);
        repository.save(car);
        return car;
    }
}

package com.ola.spring.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ola.spring.app.dto.CarDto;
import com.ola.spring.app.model.Car;
import com.ola.spring.app.repository.AppRepository;

import jakarta.validation.Valid;
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

    @PostMapping("/cars")
    public Car post (@RequestBody @Valid CarDto carDto) {
        log.info("Received new car request, model: {}", carDto.getModelo());
        Car car = new Car(carDto);
        log.info("Saiving car: {} ...", carDto.getModelo());
        return repository.save(car);
    }

    @PutMapping("/cars/{id}")
    public Car update (@PathVariable Long id, @RequestBody @Valid CarDto carDto) {
        log.info("Received update car request, id: {}", id);
        Car car = new Car(carDto);
        car.setId(id);
        log.info("Updating car with id: {} ...", id);
        return repository.save(car);
    }

    @DeleteMapping("/cars/{id}")
    public void delete (@PathVariable Long id) throws Exception {
        log.info("Received delete car request, id: {}", id);
        log.info("Validating car id {} ...", id);
        Optional<Car> car = repository.findById(id);
        if (car.isPresent()) {
            log.info("Deleting car with id {} ...", id);
            repository.delete(car.get());
        }
        log.error("Not found id {}", id);
        throw new Exception("Not found car id " + id);
    }
 }

package com.ola.spring.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class AppController {
    
    @GetMapping
    public String get () {
        return "Olá Spring";
    }

    @PostMapping
    public CarDto post (@RequestBody CarDto car) {
        log.info("Received car: {}", car.getModelo());
        return car;
    }
}

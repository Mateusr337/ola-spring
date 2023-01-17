package com.ola.spring.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AppController {
    
    @GetMapping
    public String get () {
        return "Olá Spring";
    }

    @PostMapping
    public CarDto post (@RequestBody CarDto car) {
        return car;
    }
}

package com.ola.spring.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ola.spring.app.model.Car;

public interface AppRepository extends JpaRepository<Car, Long> {
    
}

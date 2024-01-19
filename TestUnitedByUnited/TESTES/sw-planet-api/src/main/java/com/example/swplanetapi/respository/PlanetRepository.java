package com.example.Swplanetapi.respository;

import com.example.Swplanetapi.domain.Planet;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PlanetRepository extends CrudRepository<Planet, Long> {
    Optional<Planet> findByName(String name);

    List<Planet> findAll(Example<Planet> query);
}

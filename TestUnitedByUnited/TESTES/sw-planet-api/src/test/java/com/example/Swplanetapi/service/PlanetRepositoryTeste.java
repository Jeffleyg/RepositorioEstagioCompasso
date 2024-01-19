package com.example.Swplanetapi.service;


import com.example.Swplanetapi.domain.Planet;
import com.example.Swplanetapi.domain.QueryBuilder;
import com.example.Swplanetapi.respository.PlanetRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Example;

import java.util.List;
import java.util.Optional;

import static com.example.Swplanetapi.commom.PlanetConstants.PLANET;
import static com.example.Swplanetapi.commom.PlanetConstants.TATOOINE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


@DataJpaTest
public class PlanetRepositoryTeste {
    @Autowired
    private PlanetRepository planetRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @AfterEach
    public void afterEach(){
        PLANET.setId(null);
    }

    @Test
    public void createPlanet_WithValidData_ReturnsPlanet(){
        Planet planet = planetRepository.save(PLANET);

        Planet result = testEntityManager.find(Planet.class, planet.getId());
        
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(PLANET.getName());
        assertThat(result.getClimate()).isEqualTo(PLANET.getClimate());
        assertThat(result.getTerrain()).isEqualTo(PLANET.getTerrain());
    }

    @Test
    public void creatPlanet_WithValidDataa_ThrowsException(){
        Planet emptyPlanet = new Planet();
        Planet invalidPlanet = new Planet("", "");
        assertThatThrownBy(() -> planetRepository.save(emptyPlanet));
        assertThatThrownBy(() -> planetRepository.save(invalidPlanet));

    }

    @Test
    public void createPlanet_WithExistingName_ThrowsException(){
        Planet planet = testEntityManager.persistAndFlush(PLANET);
        testEntityManager.detach(planet);
        planet.setId(null);

        assertThatThrownBy(() -> planetRepository.save(planet)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getPlanet_ByExistingId_ReturnsPlanet(){
        Planet planet = testEntityManager.persistAndFlush(PLANET);
        Optional<Planet> planetOptional = planetRepository.findById(planet.getId());

        assertThat(planetOptional).isNotEmpty();
        assertThat(planetOptional.get()).isEqualTo(planet);
    }

    @Test
    public void getPlanet_ByUneExistingId_ReturnsPlanet(){
        Optional<Planet> planetOptional = planetRepository.findById(1L);

        assertThat(planetOptional).isEmpty();
    }

    @Test
    public void getPlanet_ByExistingName_ReturnsPlanet(){
        Planet planet = testEntityManager.persistAndFlush(PLANET);
        Optional<Planet> planetOptional = planetRepository.findByName(planet.getName());

        assertThat(planetOptional).isNotEmpty();
        assertThat(planetOptional.get()).isEqualTo(planet);
    }

    @Test
    public void getPlanet_ByUneExistingName_ReturnsPlanet(){
        Optional<Planet> planetOptional = planetRepository.findByName("name");

        assertThat(planetOptional).isEmpty();
    }

    @Test
    public void listPlanets_ReturnsFilteredPlanets(){
        Example<Planet> queryWithoutFilters = QueryBuilder.makeQuery((new Planet()));
        Example<Planet> queryWithFilters = QueryBuilder.makeQuery((new Planet(TATOOINE.getClimate(), TATOOINE.getTerrain())));

        List<Planet> responseWithoutFilters = planetRepository.findAll(queryWithoutFilters);
        List<Planet> responseWithFilters = planetRepository.findAll(queryWithFilters);
        //assertThat(responseWithoutFilters).isNotEmpty();
       // assertThat(planetOptional.get()).isEqualTo(planet);

    }

    @Test
    public void listPlanets_ReturnsNoPlanets(){

    }

}

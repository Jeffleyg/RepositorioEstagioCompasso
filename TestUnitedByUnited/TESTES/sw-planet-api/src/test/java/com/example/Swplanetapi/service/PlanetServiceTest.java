package com.example.Swplanetapi.service;

import static com.example.Swplanetapi.commom.PlanetConstants.PLANET;
import static com.example.Swplanetapi.commom.PlanetConstants.INVALID_PLANET;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;


import com.example.Swplanetapi.domain.Planet;
import com.example.Swplanetapi.domain.QueryBuilder;
import com.example.Swplanetapi.respository.PlanetRepository;
import org.hibernate.action.internal.EntityActionVetoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Example;

import java.util.*;

@ExtendWith(MockitoExtension.class)
//@SpringBootTest(classes = PlanetService.class)
public class PlanetServiceTest {
    //@Autowired
    @InjectMocks
    private PlanetService planetService;
    //@MockBean
    @Mock
    private PlanetRepository planetRepository;

    @Test
    public void createPlanet_WithValidData_ReturnsPlanet(){
        //Arrange
        when(planetRepository.save(PLANET)).thenReturn(PLANET);
        //Act
        Planet sut =planetService.create(PLANET);
        //Assert
        assertThat(sut).isEqualTo(PLANET);
    }

    @Test
    public void createPlanet_WithInvalidData_ThrowsException(){
        when(planetRepository.save(INVALID_PLANET)).thenThrow(RuntimeException.class);

        assertThatThrownBy(() -> planetService.create(INVALID_PLANET)).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void getPlanet_ByExistingId_ReturnsPlanet(){

        when(planetRepository.findById(PLANET.getId())).thenReturn(Optional.of(PLANET));

        Optional<Planet> result = planetService.get(PLANET.getId());

        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(PLANET);

    }

    @Test
    public void getPlanet_ByUneExistingId_ReturnsPlanet(){
        when(planetRepository.findById(INVALID_PLANET.getId())).thenReturn(Optional.empty());

        Optional<Planet> result = planetService.get(INVALID_PLANET.getId());
        assertThat(result).isEmpty();
    }


    @Test
    public void getPlanet_ByExistingName_ReturnsPlanet(){

        String name = "name3";

        Planet planetNamePresent = new Planet(name, "climate3");

        when(planetRepository.findByName(name)).thenReturn(Optional.of(planetNamePresent));

        Optional<Planet> result = planetService.getByName(name);
        assertThat(result).isPresent();
        assertThat(result.get()).isEqualTo(planetNamePresent);
    }

    @Test
    public void getPlanet_ByNotExistingName_ReturnsPlanet(){
        String nonExistingName = "NonNamePlanet";
        when(planetRepository.findByName(nonExistingName)).thenThrow(EntityActionVetoException.class);

        assertThatThrownBy(() -> planetService.getByName(nonExistingName))
                .isInstanceOf(EntityActionVetoException.class);
    }

    @Test
    public void listPlanets_ReturnsAllPlanets(){
        List<Planet> planets = new ArrayList<>(){
            {
                add(PLANET);
            }
        };
        Example<Planet> query = QueryBuilder.makeQuery(new Planet(PLANET.getName(), PLANET.getClimate()));

        when(planetRepository.findAll(query)).thenReturn(planets);
        List<Planet> result = planetService.list(PLANET.getName(), PLANET.getTerrain(), PLANET.getClimate());

        assertThat(result).isNotEmpty();
        assertThat(result).hasSize(1);
        assertThat(result.get(0)).isEqualTo((PLANET));
    }

    @Test
    public void listPlanets_ReturnsNoPlanets(){
        when(planetRepository.findAll(any())).thenReturn(Collections.emptyList());
        List<Planet> result = planetService.list(PLANET.getName(), PLANET.getTerrain(), PLANET.getClimate());
        assertThat(result).isEmpty();
    }

    @Test
    public void removePlanet_WithExistingId_doesNotThrowAnyException(){
        assertThatCode(() -> planetService.remove(1L)).doesNotThrowAnyException();
    }

    @Test
    public void removePlanet_WithUneExistingId_doesNotThrowAnyException(){

        doThrow(new RuntimeException()).when(planetRepository).deleteById(99L);

        assertThatCode(() -> planetService.remove(99L)).isInstanceOf(RuntimeException.class);
    }


}

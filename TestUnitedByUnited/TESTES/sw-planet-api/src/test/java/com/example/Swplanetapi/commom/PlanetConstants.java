package com.example.Swplanetapi.commom;

import com.example.Swplanetapi.domain.Planet;

import java.util.ArrayList;
import java.util.List;

public class PlanetConstants {
    public static final Planet PLANET = new Planet("name", "climate");
    public static final Planet INVALID_PLANET = new Planet("", "");
    public static final Planet TATOOINE = new Planet("Tatooine", "arid");
    public static final Planet ALDERAAN = new Planet("Alderaan", "temperate");
    public static final Planet YAVINIV = new Planet("yavin IV", "temperate,tropical");
    public static final List<Planet> PLANETS = new ArrayList<>(){
        {
            add(TATOOINE);
            add(ALDERAAN);
            add(YAVINIV);
        }
    };
}

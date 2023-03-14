package com.nazareno.battleoftheelements.model.terreno;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerrenosMultiton {

    private static TerrenosMultiton instance;
    private static Map<String, Terreno> terrenosMap;

    private TerrenosMultiton() {
        terrenosMap = Stream.of(new Object[][] {
                { "LAGO", new Lago() },
                { "VOLCAN", new Volcan() },
                { "PRECIPICIO", new Precipicio() },
                { "MONTANA", new Montana() },
                { "CAMINO", new Camino() },
                { "VACIO", new Vacio() },
        }).collect(Collectors.toMap(data -> (String) data[0], data -> (Terreno) data[1]));
    }

    public static TerrenosMultiton getInstance() {
        if (instance == null) {
            instance = new TerrenosMultiton();
        }
        return instance;
    }

    public Terreno getTerreno(String terreno) {
        return terrenosMap.get(terreno);
    }
}

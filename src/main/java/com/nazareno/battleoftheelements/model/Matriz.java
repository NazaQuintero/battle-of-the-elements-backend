package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.terreno.Terreno;

import java.util.ArrayList;
import java.util.Optional;

public class Matriz {
    ArrayList<Posicion> matriz;

    public Matriz(int filas) {
        this.matriz = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < filas; j++) {
                this.matriz.add(new Posicion(j, i));
            }
        }
    }

    private Optional<Posicion> getSearchedPosition(Posicion posicion) {
        return this.matriz.stream().filter(p -> p.equals(posicion)).findAny();
    }

    public void setTerrenoEnPosicion(Terreno terreno, Posicion posicion) {
        getSearchedPosition(posicion).ifPresent(searchedPos -> searchedPos.setTerreno(terreno));
    }

    public String getTipoDeTerreno(Posicion posicion) throws PositionDoesNotExistException {
        Posicion searchedPos = getSearchedPosition(posicion).orElse(null);
        if (searchedPos == null) {
            throw new PositionDoesNotExistException();
        }
        return searchedPos.getTipoDeTerreno();
    }

}

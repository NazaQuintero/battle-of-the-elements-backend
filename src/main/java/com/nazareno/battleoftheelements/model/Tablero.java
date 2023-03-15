package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.ground.Ground;

public class Tablero {
    private Matriz matriz;

    public Tablero(int filas) {
        this.matriz = new Matriz(filas);
    }

    public String getTipoDeTerreno(Posicion posicion) throws PositionDoesNotExistException {
        return this.matriz.getTipoDeTerreno(posicion);
    }

    public void setTerrenoEnPosicion(Ground ground, Posicion posicion) {
        this.matriz.setTerrenoEnPosicion(ground, posicion);
    }
}

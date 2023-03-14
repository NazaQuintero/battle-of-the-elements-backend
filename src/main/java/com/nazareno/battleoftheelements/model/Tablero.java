package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.terreno.Terreno;

public class Tablero {
    private Matriz matriz;

    public Tablero(int filas) {
        this.matriz = new Matriz(filas);
    }

    public String getTipoDeTerreno(Posicion posicion) throws PositionDoesNotExistException {
        return this.matriz.getTipoDeTerreno(posicion);
    }

    public void setTerrenoEnPosicion(Terreno terreno, Posicion posicion) {
        this.matriz.setTerrenoEnPosicion(terreno, posicion);
    }
}

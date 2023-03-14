package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.terreno.Terreno;
import com.nazareno.battleoftheelements.model.terreno.TerrenoIndefinido;

public class Posicion {
    private final int x;
    private final int y;
    private Terreno terreno;

    public void setTerreno(Terreno terreno) {
        this.terreno = terreno;
    }

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
        this.terreno = new TerrenoIndefinido();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Posicion p) {
        return this.x == p.getX() && this.y == p.getY();
    }

    public String getTipoDeTerreno() {
        return this.terreno.getType();
    }
}

package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.ground.Ground;
import com.nazareno.battleoftheelements.model.ground.UndefinedGround;

public class Posicion {
    private final int x;
    private final int y;
    private Ground ground;

    public void setTerreno(Ground ground) {
        this.ground = ground;
    }

    public Posicion(int x, int y) {
        this.x = x;
        this.y = y;
        this.ground = new UndefinedGround();
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
        return this.ground.getType();
    }
}

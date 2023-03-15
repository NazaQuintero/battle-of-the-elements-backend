package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.ground.Ground;
import com.nazareno.battleoftheelements.model.ground.UndefinedGround;

public class Position {
    private final int coordinateX;
    private final int coordinateY;
    private Ground ground;

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public Position(int coordinateX, int coordinateY) {
        this.coordinateX = coordinateX;
        this.coordinateY = coordinateY;
        this.ground = new UndefinedGround();
    }

    public int getCoordinateX() {
        return this.coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public boolean equals(Position p) {
        return this.coordinateX == p.getCoordinateX() && this.coordinateY == p.getCoordinateY();
    }

    public String getGroundType() {
        return this.ground.getType();
    }
}

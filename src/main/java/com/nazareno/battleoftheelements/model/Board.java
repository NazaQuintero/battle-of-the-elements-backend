package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.exception.PositionDoesNotExistException;
import com.nazareno.battleoftheelements.model.ground.Ground;

public class Board {
    private Matrix matrix;

    public Board(int rows) {
        this.matrix = new Matrix(rows);
    }

    public String getGroundType(Position position) throws PositionDoesNotExistException {
        return this.matrix.getGroundType(position);
    }

    public void setGroundInPosition(Ground ground, Position position) {
        this.matrix.setGroundInPosition(ground, position);
    }
}

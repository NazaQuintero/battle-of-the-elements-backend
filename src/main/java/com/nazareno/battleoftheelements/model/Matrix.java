package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.exception.PositionDoesNotExistException;
import com.nazareno.battleoftheelements.model.ground.Ground;

import java.util.ArrayList;
import java.util.Optional;

public class Matrix {
    ArrayList<Position> matriz;

    public Matrix(int rows) {
        this.matriz = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                this.matriz.add(new Position(j, i));
            }
        }
    }

    private Optional<Position> getSearchedPosition(Position position) {
        return this.matriz.stream().filter(p -> p.equals(position)).findAny();
    }

    public void setGroundInPosition(Ground ground, Position position) {
        getSearchedPosition(position).ifPresent(searchedPos -> searchedPos.setGround(ground));
    }

    public String getGroundType(Position position) throws PositionDoesNotExistException {
        Position searchedPosition = getSearchedPosition(position).orElse(null);
        if (searchedPosition == null) {
            throw new PositionDoesNotExistException();
        }
        return searchedPosition.getGroundType();
    }

}

package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.Position;
import com.nazareno.battleoftheelements.model.PositionDoesNotExistException;
import com.nazareno.battleoftheelements.model.Board;
import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.ground.Mountain;
import com.nazareno.battleoftheelements.model.ground.GroundMultiton;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    Board board;

    String[][] grounds = {
        {"LAKE"     , "LAKE"    , "CLIFF"   , "CLIFF"   , "CLIFF"   , "VOID"    , "VOLCANO" , "VOLCANO" },
        {"LAKE"     , "LAKE"    , "CLIFF"   , "VOID"    , "VOLCANO" , "VOLCANO" , "VOLCANO" , "VOLCANO" },
        {"CLIFF"    , "VOLCANO" , "VOLCANO" , "VOLCANO" , "VOLCANO" , "CLIFF"   , "CLIFF"   , "CLIFF"   },
        {"VOLCANO"  , "PATH"    , "PATH"    , "PATH"    , "LAKE"    , "VOID"    , "PATH"    , "PATH"    },
        {"PATH"     , "PATH"    , "VOID"    , "PATH"    , "PATH"    , "PATH"    , "PATH"    , "CLIFF"   },
        {"PATH"     , "PATH"    , "PATH"    , "VOID"    , "MOUNTAIN", "MOUNTAIN", "MOUNTAIN", "CLIFF"   },
        {"CLIFF"    , "MOUNTAIN", "MOUNTAIN", "MOUNTAIN", "MOUNTAIN", "LAKE"    , "LAKE"    , "LAKE"    },
        {"CLIFF"    , "CLIFF"   , "MOUNTAIN", "CLIFF"   , "VOID"    , "LAKE"    , "LAKE"    , "LAKE"    }
    };

    int rowsAndColsQuantity = 8;

    @Before
    public void init() {
        board = new Board(rowsAndColsQuantity);
        for (int i = 0; i < rowsAndColsQuantity; i++) {
            for (int j = 0; j < rowsAndColsQuantity; j++) {
                board.setGroundInPosition(GroundMultiton.getInstance().getGround(grounds[i][j]), new Position(j,i));
            }
        }
    }

    @Test
    public void mountainIsSetToTheFirstPositionOfTheBoard() throws PositionDoesNotExistException {
        Position pos = new Position(0,0);
        board.setGroundInPosition(new Mountain(), pos);
        assertEquals("MOUNTAIN", board.getGroundType(pos));
    }

    @Test
    public void mountainIsSetInPos4x7yOfTheBoard() throws PositionDoesNotExistException {
        Position pos = new Position(4,7);
        board.setGroundInPosition(new Mountain(), pos);
        assertEquals("MOUNTAIN", board.getGroundType(pos));
    }

    @Test
    public void pos4x3yIsTypeLake() throws PositionDoesNotExistException {
        assertEquals("LAKE", board.getGroundType(new Position(4, 3)));
    }

    @Test
    public void pos5x3yisTypeVoid() throws PositionDoesNotExistException {
        assertEquals("VOID", board.getGroundType(new Position(5, 3)));
    }

    @Test
    public void pos7x0yIsTypeVolcano() throws PositionDoesNotExistException {
        assertEquals("VOLCANO", board.getGroundType(new Position(7, 0)));
    }

    @Test
    public void pos7x3yIsTypePath() throws PositionDoesNotExistException {
        assertEquals("PATH", board.getGroundType(new Position(7, 3)));
    }

    @Test
    public void pos2x7yIsTypeMountain() throws PositionDoesNotExistException {
        assertEquals("MOUNTAIN", board.getGroundType(new Position(2, 7)));
    }

    @Test
    public void pos3x7yIsTypeCliff() throws PositionDoesNotExistException {
        assertEquals("CLIFF", board.getGroundType(new Position(3, 7)));
    }
}

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

    String[][] terrenos = {
        {"LAGO"         , "LAGO"        , "PRECIPICIO"  , "PRECIPICIO"  , "PRECIPICIO"  , "VACIO"       , "VOLCAN"      , "VOLCAN"      },
        {"LAGO"         , "LAGO"        , "PRECIPICIO"  , "VACIO"       , "VOLCAN"      , "VOLCAN"      , "VOLCAN"      , "VOLCAN"      },
        {"PRECIPICIO"   , "VOLCAN"      , "VOLCAN"      , "VOLCAN"      , "VOLCAN"      , "PRECIPICIO"  , "PRECIPICIO"  , "PRECIPICIO"  },
        {"VOLCAN"       , "CAMINO"      , "CAMINO"      , "CAMINO"      , "LAGO"        , "VACIO"       , "CAMINO"      , "CAMINO"      },
        {"CAMINO"       , "CAMINO"      , "VACIO"       , "CAMINO"      , "CAMINO"      , "CAMINO"      , "CAMINO"      , "PRECIPICIO"  },
        {"CAMINO"       , "CAMINO"      , "CAMINO"      , "VACIO"       , "MONTANA"     , "MONTANA"     , "MONTANA"     , "PRECIPICIO"  },
        {"PRECIPICIO"   , "MONTANA"     , "MONTANA"     , "MONTANA"     , "MONTANA"     , "LAGO"        , "LAGO"        , "LAGO"        },
        {"PRECIPICIO"   , "PRECIPICIO"  , "MONTANA"     , "PRECIPICIO"  , "VACIO"       , "LAGO"        , "LAGO"        , "LAGO"        }
    };

    int cantidadDeFilasYCol = 8;

    @Before
    public void init() {
        board = new Board(cantidadDeFilasYCol);
        for (int i = 0; i < cantidadDeFilasYCol; i++) {
            for (int j = 0; j < cantidadDeFilasYCol; j++) {
                board.setGroundInPosition(GroundMultiton.getInstance().getGround(terrenos[i][j]), new Position(j,i));
            }
        }
    }

    @Test
    public void seAsignaTipoMontanaAPrimerPosicionDelTablero() throws PositionDoesNotExistException {
        Position pos = new Position(0,0);
        board.setGroundInPosition(new Mountain(), pos);
        assertEquals("MONTANA", board.getGroundType(pos));
    }

    @Test
    public void seAsingaTipoMontanaEnPos4x7yDelTablero() throws PositionDoesNotExistException {
        Position pos = new Position(4,7);
        board.setGroundInPosition(new Mountain(), pos);
        assertEquals("MONTANA", board.getGroundType(pos));
    }

    @Test
    public void pos4x3yEsDeTipoLago() throws PositionDoesNotExistException {
        assertEquals("LAGO", board.getGroundType(new Position(4, 3)));
    }

    @Test
    public void pos5x3yEsDeTipoVacio() throws PositionDoesNotExistException {
        assertEquals("VACIO", board.getGroundType(new Position(5, 3)));
    }

    @Test
    public void pos7x0yEsDeTipoVolcan() throws PositionDoesNotExistException {
        assertEquals("VOLCAN", board.getGroundType(new Position(7, 0)));
    }

    @Test
    public void pos7x3yEsDeTipoCamino() throws PositionDoesNotExistException {
        assertEquals("CAMINO", board.getGroundType(new Position(7, 3)));
    }

    @Test
    public void pos2x7yEsDeTipoMontana() throws PositionDoesNotExistException {
        assertEquals("MONTANA", board.getGroundType(new Position(2, 7)));
    }

    @Test
    public void pos3x7yEsDeTipoPrecipicio() throws PositionDoesNotExistException {
        assertEquals("PRECIPICIO", board.getGroundType(new Position(3, 7)));
    }
}

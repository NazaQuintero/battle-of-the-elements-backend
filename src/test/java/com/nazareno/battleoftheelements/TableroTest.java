package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.Posicion;
import com.nazareno.battleoftheelements.model.PositionDoesNotExistException;
import com.nazareno.battleoftheelements.model.Tablero;
import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.ground.Mountain;
import com.nazareno.battleoftheelements.model.ground.GroundMultiton;

import static org.junit.Assert.assertEquals;

public class TableroTest {
    Tablero tablero;

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
        tablero = new Tablero(cantidadDeFilasYCol);
        for (int i = 0; i < cantidadDeFilasYCol; i++) {
            for (int j = 0; j < cantidadDeFilasYCol; j++) {
                tablero.setTerrenoEnPosicion(GroundMultiton.getInstance().getGround(terrenos[i][j]), new Posicion(j,i));
            }
        }
    }

    @Test
    public void seAsignaTipoMontanaAPrimerPosicionDelTablero() throws PositionDoesNotExistException {
        Posicion pos = new Posicion(0,0);
        tablero.setTerrenoEnPosicion(new Mountain(), pos);
        assertEquals("MONTANA", tablero.getTipoDeTerreno(pos));
    }

    @Test
    public void seAsingaTipoMontanaEnPos4x7yDelTablero() throws PositionDoesNotExistException {
        Posicion pos = new Posicion(4,7);
        tablero.setTerrenoEnPosicion(new Mountain(), pos);
        assertEquals("MONTANA", tablero.getTipoDeTerreno(pos));
    }

    @Test
    public void pos4x3yEsDeTipoLago() throws PositionDoesNotExistException {
        assertEquals("LAGO", tablero.getTipoDeTerreno(new Posicion(4, 3)));
    }

    @Test
    public void pos5x3yEsDeTipoVacio() throws PositionDoesNotExistException {
        assertEquals("VACIO", tablero.getTipoDeTerreno(new Posicion(5, 3)));
    }

    @Test
    public void pos7x0yEsDeTipoVolcan() throws PositionDoesNotExistException {
        assertEquals("VOLCAN", tablero.getTipoDeTerreno(new Posicion(7, 0)));
    }

    @Test
    public void pos7x3yEsDeTipoCamino() throws PositionDoesNotExistException {
        assertEquals("CAMINO", tablero.getTipoDeTerreno(new Posicion(7, 3)));
    }

    @Test
    public void pos2x7yEsDeTipoMontana() throws PositionDoesNotExistException {
        assertEquals("MONTANA", tablero.getTipoDeTerreno(new Posicion(2, 7)));
    }

    @Test
    public void pos3x7yEsDeTipoPrecipicio() throws PositionDoesNotExistException {
        assertEquals("PRECIPICIO", tablero.getTipoDeTerreno(new Posicion(3, 7)));
    }
}

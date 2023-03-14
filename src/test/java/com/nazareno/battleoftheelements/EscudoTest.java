package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.escudo.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EscudoTest {

    @Test
    public void sinEscudoNoCubreDanio() {
        Escudo escudo = new SinEscudo();
        assertEquals(20, escudo.cubrirDanio(20));
    }

    @Test
    public void unPtoDeEscudoCubreUn10PorCiento() {
        Escudo escudo = new UnEscudo();
        assertEquals(9, escudo.cubrirDanio(10));
    }

    @Test
    public void dosEscudosCubreUn20PorCiento() {
        Escudo escudo = new DosEscudos();
        assertEquals(8, escudo.cubrirDanio(10));
    }

    @Test
    public void masDeDosEscudosCubreUn80PorCiento() {
        Escudo escudo = new MasDeDosEscudos();
        assertEquals(2, escudo.cubrirDanio(10));
    }
}

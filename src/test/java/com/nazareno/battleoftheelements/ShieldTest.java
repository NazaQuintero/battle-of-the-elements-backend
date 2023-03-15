package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.escudo.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShieldTest {

    @Test
    public void sinEscudoNoCubreDanio() {
        Shield shield = new WithoutShield();
        assertEquals(20, shield.cubrirDanio(20));
    }

    @Test
    public void unPtoDeEscudoCubreUn10PorCiento() {
        Shield shield = new UnShield();
        assertEquals(9, shield.cubrirDanio(10));
    }

    @Test
    public void dosEscudosCubreUn20PorCiento() {
        Shield shield = new DosEscudos();
        assertEquals(8, shield.cubrirDanio(10));
    }

    @Test
    public void masDeDosEscudosCubreUn80PorCiento() {
        Shield shield = new MasDeDosEscudos();
        assertEquals(2, shield.cubrirDanio(10));
    }
}

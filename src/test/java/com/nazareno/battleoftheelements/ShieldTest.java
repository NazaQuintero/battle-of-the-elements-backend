package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.shield.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShieldTest {

    @Test
    public void sinEscudoNoCubreDanio() {
        Shield shield = new WithoutShield();
        assertEquals(20, shield.coverDamage(20));
    }

    @Test
    public void unPtoDeEscudoCubreUn10PorCiento() {
        Shield shield = new OneShield();
        assertEquals(9, shield.coverDamage(10));
    }

    @Test
    public void dosEscudosCubreUn20PorCiento() {
        Shield shield = new TwoShields();
        assertEquals(8, shield.coverDamage(10));
    }

    @Test
    public void masDeDosEscudosCubreUn80PorCiento() {
        Shield shield = new MoreThanTwoShields();
        assertEquals(2, shield.coverDamage(10));
    }
}

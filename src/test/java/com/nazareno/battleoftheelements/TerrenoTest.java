package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.character.Character;
import com.nazareno.battleoftheelements.model.ground.Void;
import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.character.*;
import com.nazareno.battleoftheelements.model.ground.*;

import static org.junit.Assert.assertEquals;

public class TerrenoTest {

    Character unCharacterDeTierra;
    Character unCharacterDeAgua;
    Character unCharacterDeAire;
    Character unCharacterDeFuego;
    Mountain mountain;
    Cliff cliff;
    Lake lake;
    Volcano volcano;
    Path path;
    Void aVoid;

    @Before
    public void init() {
        unCharacterDeTierra = new RockCharacter().withEnergy(new Energy(20));
        unCharacterDeAgua = new WaterCharacter().withEnergy(new Energy(20));
        unCharacterDeAire = new AirCharacter().withEnergy(new Energy(20));
        unCharacterDeFuego = new FireCharacter().withEnergy(new Energy(20));
        mountain = new Mountain();
        cliff = new Cliff();
        lake = new Lake();
        volcano = new Volcano();
        path = new Path();
        aVoid = new Void();
    }

    @Test
    public void unPersonajeDeTierraPasaPorMontana() {
        unCharacterDeTierra.passThrough(mountain);
        assertEquals(20, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorMontana() {
        unCharacterDeAgua.passThrough(mountain);
        assertEquals(19, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorMontana() {
        unCharacterDeFuego.passThrough(mountain);
        assertEquals(19, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorMontana() {
        unCharacterDeAire.passThrough(mountain);
        assertEquals(18, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorPrecipicio() {
        unCharacterDeTierra.passThrough(cliff);
        assertEquals(18, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorPrecipicio() {
        unCharacterDeAgua.passThrough(cliff);
        assertEquals(19, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorPrecipicio() {
        unCharacterDeFuego.passThrough(cliff);
        assertEquals(19, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorPrecipicio() {
        unCharacterDeAire.passThrough(cliff);
        assertEquals(20, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorLago() {
        unCharacterDeTierra.passThrough(lake);
        assertEquals(19, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorLago() {
        unCharacterDeAgua.passThrough(lake);
        assertEquals(20, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorLago() {
        unCharacterDeFuego.passThrough(lake);
        assertEquals(18, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorLago() {
        unCharacterDeAire.passThrough(lake);
        assertEquals(19, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorVolcan() {
        unCharacterDeTierra.passThrough(volcano);
        assertEquals(19, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorVolcan() {
        unCharacterDeAgua.passThrough(volcano);
        assertEquals(18, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorVolcan() {
        unCharacterDeFuego.passThrough(volcano);
        assertEquals(20, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorVolcan() {
        unCharacterDeAire.passThrough(volcano);
        assertEquals(19, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorCamino() {
        unCharacterDeTierra.passThrough(path);
        assertEquals(19, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorCamino() {
        unCharacterDeAgua.passThrough(path);
        assertEquals(19, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorCamino() {
        unCharacterDeFuego.passThrough(path);
        assertEquals(19, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorCamino() {
        unCharacterDeAire.passThrough(path);
        assertEquals(19, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorVacio() {
        unCharacterDeTierra.passThrough(aVoid);
        assertEquals(5, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorVacio() {
        unCharacterDeAgua.passThrough(aVoid);
        assertEquals(5, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorVacio() {
        unCharacterDeFuego.passThrough(aVoid);
        assertEquals(5, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorVacio() {
        unCharacterDeAire.passThrough(aVoid);
        assertEquals(5, unCharacterDeAire.getEnergy());
    }
}

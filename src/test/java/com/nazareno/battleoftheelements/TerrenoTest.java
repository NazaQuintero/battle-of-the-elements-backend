package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.personaje.Character;
import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.personaje.*;
import com.nazareno.battleoftheelements.model.terreno.*;

import static org.junit.Assert.assertEquals;

public class TerrenoTest {

    Character unCharacterDeTierra;
    Character unCharacterDeAgua;
    Character unCharacterDeAire;
    Character unCharacterDeFuego;
    Montana montana;
    Precipicio precipicio;
    Lago lago;
    Volcan volcan;
    Camino camino;
    Vacio vacio;

    @Before
    public void init() {
        unCharacterDeTierra = new RockCharacter().withEnergy(new Energy(20));
        unCharacterDeAgua = new WaterCharacter().withEnergy(new Energy(20));
        unCharacterDeAire = new AirCharacter().withEnergy(new Energy(20));
        unCharacterDeFuego = new FireCharacter().withEnergy(new Energy(20));
        montana = new Montana();
        precipicio = new Precipicio();
        lago = new Lago();
        volcan = new Volcan();
        camino = new Camino();
        vacio = new Vacio();
    }

    @Test
    public void unPersonajeDeTierraPasaPorMontana() {
        unCharacterDeTierra.passThrough(montana);
        assertEquals(20, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorMontana() {
        unCharacterDeAgua.passThrough(montana);
        assertEquals(19, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorMontana() {
        unCharacterDeFuego.passThrough(montana);
        assertEquals(19, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorMontana() {
        unCharacterDeAire.passThrough(montana);
        assertEquals(18, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorPrecipicio() {
        unCharacterDeTierra.passThrough(precipicio);
        assertEquals(18, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorPrecipicio() {
        unCharacterDeAgua.passThrough(precipicio);
        assertEquals(19, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorPrecipicio() {
        unCharacterDeFuego.passThrough(precipicio);
        assertEquals(19, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorPrecipicio() {
        unCharacterDeAire.passThrough(precipicio);
        assertEquals(20, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorLago() {
        unCharacterDeTierra.passThrough(lago);
        assertEquals(19, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorLago() {
        unCharacterDeAgua.passThrough(lago);
        assertEquals(20, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorLago() {
        unCharacterDeFuego.passThrough(lago);
        assertEquals(18, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorLago() {
        unCharacterDeAire.passThrough(lago);
        assertEquals(19, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorVolcan() {
        unCharacterDeTierra.passThrough(volcan);
        assertEquals(19, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorVolcan() {
        unCharacterDeAgua.passThrough(volcan);
        assertEquals(18, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorVolcan() {
        unCharacterDeFuego.passThrough(volcan);
        assertEquals(20, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorVolcan() {
        unCharacterDeAire.passThrough(volcan);
        assertEquals(19, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorCamino() {
        unCharacterDeTierra.passThrough(camino);
        assertEquals(19, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorCamino() {
        unCharacterDeAgua.passThrough(camino);
        assertEquals(19, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorCamino() {
        unCharacterDeFuego.passThrough(camino);
        assertEquals(19, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorCamino() {
        unCharacterDeAire.passThrough(camino);
        assertEquals(19, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeTierraPasaPorVacio() {
        unCharacterDeTierra.passThrough(vacio);
        assertEquals(5, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaPasaPorVacio() {
        unCharacterDeAgua.passThrough(vacio);
        assertEquals(5, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorVacio() {
        unCharacterDeFuego.passThrough(vacio);
        assertEquals(5, unCharacterDeFuego.getEnergy());
    }

    @Test
    public void unPersonajeDeAirePasaPorVacio() {
        unCharacterDeAire.passThrough(vacio);
        assertEquals(5, unCharacterDeAire.getEnergy());
    }
}

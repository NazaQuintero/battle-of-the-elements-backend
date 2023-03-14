package com.nazareno.battleoftheelements;

import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.personaje.*;
import com.nazareno.battleoftheelements.model.terreno.*;

import static org.junit.Assert.assertEquals;

public class TerrenoTest {

    Personaje unPersonajeDeTierra;
    Personaje unPersonajeDeAgua;
    Personaje unPersonajeDeAire;
    Personaje unPersonajeDeFuego;
    Montana montana;
    Precipicio precipicio;
    Lago lago;
    Volcan volcan;
    Camino camino;
    Vacio vacio;

    @Before
    public void init() {
        unPersonajeDeTierra = new PersonajeTierra().conEnergia(new Energia(20));
        unPersonajeDeAgua = new PersonajeAgua().conEnergia(new Energia(20));
        unPersonajeDeAire = new PersonajeAire().conEnergia(new Energia(20));
        unPersonajeDeFuego = new PersonajeFuego().conEnergia(new Energia(20));
        montana = new Montana();
        precipicio = new Precipicio();
        lago = new Lago();
        volcan = new Volcan();
        camino = new Camino();
        vacio = new Vacio();
    }

    @Test
    public void unPersonajeDeTierraPasaPorMontana() {
        unPersonajeDeTierra.pasarPor(montana);
        assertEquals(20, unPersonajeDeTierra.getEnergia());
    }

    @Test
    public void unPersonajeDeAguaPasaPorMontana() {
        unPersonajeDeAgua.pasarPor(montana);
        assertEquals(19, unPersonajeDeAgua.getEnergia());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorMontana() {
        unPersonajeDeFuego.pasarPor(montana);
        assertEquals(19, unPersonajeDeFuego.getEnergia());
    }

    @Test
    public void unPersonajeDeAirePasaPorMontana() {
        unPersonajeDeAire.pasarPor(montana);
        assertEquals(18, unPersonajeDeAire.getEnergia());
    }

    @Test
    public void unPersonajeDeTierraPasaPorPrecipicio() {
        unPersonajeDeTierra.pasarPor(precipicio);
        assertEquals(18, unPersonajeDeTierra.getEnergia());
    }

    @Test
    public void unPersonajeDeAguaPasaPorPrecipicio() {
        unPersonajeDeAgua.pasarPor(precipicio);
        assertEquals(19, unPersonajeDeAgua.getEnergia());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorPrecipicio() {
        unPersonajeDeFuego.pasarPor(precipicio);
        assertEquals(19, unPersonajeDeFuego.getEnergia());
    }

    @Test
    public void unPersonajeDeAirePasaPorPrecipicio() {
        unPersonajeDeAire.pasarPor(precipicio);
        assertEquals(20, unPersonajeDeAire.getEnergia());
    }

    @Test
    public void unPersonajeDeTierraPasaPorLago() {
        unPersonajeDeTierra.pasarPor(lago);
        assertEquals(19, unPersonajeDeTierra.getEnergia());
    }

    @Test
    public void unPersonajeDeAguaPasaPorLago() {
        unPersonajeDeAgua.pasarPor(lago);
        assertEquals(20, unPersonajeDeAgua.getEnergia());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorLago() {
        unPersonajeDeFuego.pasarPor(lago);
        assertEquals(18, unPersonajeDeFuego.getEnergia());
    }

    @Test
    public void unPersonajeDeAirePasaPorLago() {
        unPersonajeDeAire.pasarPor(lago);
        assertEquals(19, unPersonajeDeAire.getEnergia());
    }

    @Test
    public void unPersonajeDeTierraPasaPorVolcan() {
        unPersonajeDeTierra.pasarPor(volcan);
        assertEquals(19, unPersonajeDeTierra.getEnergia());
    }

    @Test
    public void unPersonajeDeAguaPasaPorVolcan() {
        unPersonajeDeAgua.pasarPor(volcan);
        assertEquals(18, unPersonajeDeAgua.getEnergia());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorVolcan() {
        unPersonajeDeFuego.pasarPor(volcan);
        assertEquals(20, unPersonajeDeFuego.getEnergia());
    }

    @Test
    public void unPersonajeDeAirePasaPorVolcan() {
        unPersonajeDeAire.pasarPor(volcan);
        assertEquals(19, unPersonajeDeAire.getEnergia());
    }

    @Test
    public void unPersonajeDeTierraPasaPorCamino() {
        unPersonajeDeTierra.pasarPor(camino);
        assertEquals(19, unPersonajeDeTierra.getEnergia());
    }

    @Test
    public void unPersonajeDeAguaPasaPorCamino() {
        unPersonajeDeAgua.pasarPor(camino);
        assertEquals(19, unPersonajeDeAgua.getEnergia());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorCamino() {
        unPersonajeDeFuego.pasarPor(camino);
        assertEquals(19, unPersonajeDeFuego.getEnergia());
    }

    @Test
    public void unPersonajeDeAirePasaPorCamino() {
        unPersonajeDeAire.pasarPor(camino);
        assertEquals(19, unPersonajeDeAire.getEnergia());
    }

    @Test
    public void unPersonajeDeTierraPasaPorVacio() {
        unPersonajeDeTierra.pasarPor(vacio);
        assertEquals(5, unPersonajeDeTierra.getEnergia());
    }

    @Test
    public void unPersonajeDeAguaPasaPorVacio() {
        unPersonajeDeAgua.pasarPor(vacio);
        assertEquals(5, unPersonajeDeAgua.getEnergia());
    }

    @Test
    public void unPersonajeDeFuegoPasaPorVacio() {
        unPersonajeDeFuego.pasarPor(vacio);
        assertEquals(5, unPersonajeDeFuego.getEnergia());
    }

    @Test
    public void unPersonajeDeAirePasaPorVacio() {
        unPersonajeDeAire.pasarPor(vacio);
        assertEquals(5, unPersonajeDeAire.getEnergia());
    }
}

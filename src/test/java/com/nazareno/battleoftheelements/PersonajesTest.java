package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.escudo.DosEscudos;
import com.nazareno.battleoftheelements.model.escudo.MasDeDosEscudos;
import com.nazareno.battleoftheelements.model.escudo.UnEscudo;
import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.personaje.*;

import static org.junit.Assert.assertEquals;

public class PersonajesTest {

    Personaje unPersonajeDeAgua;
    Personaje unPersonajeDeAguaCon20DeEnergia;;
    Personaje unPersonajeDeTierra;
    Personaje unPersonajeDeFuego;
    Personaje unPersonajeDeAire;

    @Before
    public void init() throws TipoDePersonajeDesconocidoException {
        PersonajeFactory factory = PersonajeFactory.getInstance();

        int valorEnergiaInicial = 0;
        int valorVidaInicial = 100;

        unPersonajeDeAgua = factory.getPersonaje("AGUA")
                .conNombre("Nami")
                .conEnergia(new Energia(valorEnergiaInicial))
                .conVida(new Vida(valorVidaInicial));

        unPersonajeDeAguaCon20DeEnergia = unPersonajeDeAgua.clone().conEnergia(new Energia(20));

        unPersonajeDeTierra = factory.getPersonaje("TIERRA")
                .conNombre("Blitzcrank")
                .conEnergia(new Energia(valorEnergiaInicial))
                .conVida(new Vida(valorVidaInicial));

        unPersonajeDeFuego = factory.getPersonaje("FUEGO")
                .conNombre("Wukong")
                .conEnergia(new Energia(valorEnergiaInicial))
                .conVida(new Vida(valorVidaInicial));

        unPersonajeDeAire = factory.getPersonaje("AIRE")
                .conNombre("Ashe")
                .conEnergia(new Energia(valorEnergiaInicial))
                .conVida(new Vida(valorVidaInicial));
    }

    @Test
    public void unPersonajeDeAguaEsAlimentado() throws PersonajeAlimentadoMasDe3VecesException {
        unPersonajeDeAgua.alimentar();
        assertEquals(10, unPersonajeDeAgua.getEnergia());
    }

    @Test
    public void unPersonajeDeAguaEsAlimentado3Veces() throws PersonajeAlimentadoMasDe3VecesException {
        alimentar3Veces(unPersonajeDeAgua);
        assertEquals(20, unPersonajeDeAgua.getEnergia());
    }

    private void alimentar3Veces(Personaje personaje) throws PersonajeAlimentadoMasDe3VecesException {
        for (int i = 0; i < 3; i++) {
            personaje.alimentar();
        }
    }

    @Test(expected = PersonajeAlimentadoMasDe3VecesException.class)
    public void unPersonajeDeAguaEsAlimentadoMasDe3Veces() throws PersonajeAlimentadoMasDe3VecesException {
        alimentar3Veces(unPersonajeDeAgua);
        unPersonajeDeAgua.alimentar();
    }

    @Test
    public void unPersonajeDeTierraEsAlimentado() throws PersonajeAlimentadoMasDe3VecesException {
        unPersonajeDeTierra.alimentar();
        assertEquals(8, unPersonajeDeTierra.getEnergia());
    }

    @Test
    public void unPerosnajeDeTierraEsAlimentado2Veces() throws PersonajeAlimentadoMasDe3VecesException {
        unPersonajeDeTierra.alimentar();
        unPersonajeDeTierra.alimentar();
        assertEquals(16, unPersonajeDeTierra.getEnergia());
    }

    @Test
    public void unPersonajeDeFuegoEsAlimentado() throws PersonajeAlimentadoMasDe3VecesException {
        unPersonajeDeFuego.conVida(new Vida(10));
        unPersonajeDeFuego.alimentar();
        assertEquals(25, unPersonajeDeFuego.getVida());
    }

    @Test
    public void unPersonajeDeFuegoEsAlimentado9Veces() throws PersonajeAlimentadoMasDe3VecesException {
        for (int i = 0; i < 3; i++) {
            alimentar3Veces(unPersonajeDeFuego);
        }
        assertEquals(100, unPersonajeDeFuego.getVida());
    }

    @Test
    public void unPersonajeDeAireEsAlimentado() throws PersonajeAlimentadoMasDe3VecesException {
        unPersonajeDeAire.conEnergia(new Energia(25));
        unPersonajeDeAire.alimentar();
        assertEquals(25, unPersonajeDeAire.getEnergia());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeAireSinEscudo() {
        unPersonajeDeAguaCon20DeEnergia.atacar(unPersonajeDeAire);
        assertEquals(80, unPersonajeDeAire.getVida());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeAireConUnEscudo() {
        unPersonajeDeAire.setEscudo(new UnEscudo());
        unPersonajeDeAguaCon20DeEnergia.atacar(unPersonajeDeAire);
        assertEquals(82, unPersonajeDeAire.getVida());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeAireConDosEscudos() {
        unPersonajeDeAire.setEscudo(new DosEscudos());
        unPersonajeDeAguaCon20DeEnergia.atacar(unPersonajeDeAire);
        assertEquals(84, unPersonajeDeAire.getVida());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeAireConMasDeDosEscudos() {
        unPersonajeDeAire.setEscudo(new MasDeDosEscudos());
        unPersonajeDeAguaCon20DeEnergia.atacar(unPersonajeDeAire);
        assertEquals(96, unPersonajeDeAire.getVida());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeFuegoSinEscudo() {
        unPersonajeDeAguaCon20DeEnergia.atacar(unPersonajeDeFuego);
        assertEquals(70, unPersonajeDeFuego.getVida());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeFuegoConEscudo() {
        unPersonajeDeFuego.setEscudo(new UnEscudo());
        unPersonajeDeAguaCon20DeEnergia.atacar(unPersonajeDeFuego);
        assertEquals(73, unPersonajeDeFuego.getVida());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeFuegoConDosEscudos() {
        unPersonajeDeFuego.setEscudo(new DosEscudos());
        unPersonajeDeAguaCon20DeEnergia.atacar(unPersonajeDeFuego);
        assertEquals(76, unPersonajeDeFuego.getVida());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeFuegoConMasDeDosEscudos() {
        unPersonajeDeFuego.setEscudo(new MasDeDosEscudos());
        unPersonajeDeAguaCon20DeEnergia.atacar(unPersonajeDeFuego);
        assertEquals(94, unPersonajeDeFuego.getVida());
    }

    @Test
    public void unPersonajeDeFuegoAtacaOtroPersonajeDeFuegoSinEscudo() {
        unPersonajeDeFuego.clone().atacar(unPersonajeDeFuego);
        assertEquals(80, unPersonajeDeFuego.getVida());
    }

    @Test
    public void unPersonajeDeFuegoAtacaAPersonajeDeAireSinEscudo() {
        unPersonajeDeFuego.atacar(unPersonajeDeAire);
        assertEquals(70, unPersonajeDeAire.getVida());
    }

    @Test
    public void unPersonajeDeFuegoAtacaAPersonajeDeAguaSinEscudo() {
        unPersonajeDeFuego.atacar(unPersonajeDeAgua);
        assertEquals(90, unPersonajeDeAgua.getVida());
    }

    @Test
    public void unPersonajeDeAireAtacaAPersonajeDeTierraSinEscudo() {
        unPersonajeDeAire.atacar(unPersonajeDeTierra);
        assertEquals(80, unPersonajeDeTierra.getVida());
    }

    @Test
    public void unPersonajeDeAireAtacaAPersonajeDeFuegoSinEscudo() {
        unPersonajeDeAire.atacar(unPersonajeDeFuego);
        assertEquals(90, unPersonajeDeFuego.getVida());
    }
}

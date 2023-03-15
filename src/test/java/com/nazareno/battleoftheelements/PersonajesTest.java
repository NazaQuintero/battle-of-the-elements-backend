package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.shield.TwoShields;
import com.nazareno.battleoftheelements.model.shield.MoreThanTwoShields;
import com.nazareno.battleoftheelements.model.shield.OneShield;
import com.nazareno.battleoftheelements.model.character.Character;
import org.junit.Before;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.character.*;

import static org.junit.Assert.assertEquals;

public class PersonajesTest {

    Character unCharacterDeAgua;
    Character unCharacterDeAguaCon20DeEnergia;;
    Character unCharacterDeTierra;
    Character unCharacterDeFuego;
    Character unCharacterDeAire;

    @Before
    public void init() throws UnknownCharacterTypeException {
        CharacterFactory factory = CharacterFactory.getInstance();

        int valorEnergiaInicial = 0;
        int valorVidaInicial = 100;

        unCharacterDeAgua = factory.getCharacter("AGUA")
                .named("Nami")
                .withEnergy(new Energy(valorEnergiaInicial))
                .withLife(new Life(valorVidaInicial));

        unCharacterDeAguaCon20DeEnergia = unCharacterDeAgua.clone().withEnergy(new Energy(20));

        unCharacterDeTierra = factory.getCharacter("TIERRA")
                .named("Blitzcrank")
                .withEnergy(new Energy(valorEnergiaInicial))
                .withLife(new Life(valorVidaInicial));

        unCharacterDeFuego = factory.getCharacter("FUEGO")
                .named("Wukong")
                .withEnergy(new Energy(valorEnergiaInicial))
                .withLife(new Life(valorVidaInicial));

        unCharacterDeAire = factory.getCharacter("AIRE")
                .named("Ashe")
                .withEnergy(new Energy(valorEnergiaInicial))
                .withLife(new Life(valorVidaInicial));
    }

    @Test
    public void unPersonajeDeAguaEsAlimentado() throws CharacterFedMoreThan3TimesException {
        unCharacterDeAgua.feed();
        assertEquals(10, unCharacterDeAgua.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaEsAlimentado3Veces() throws CharacterFedMoreThan3TimesException {
        alimentar3Veces(unCharacterDeAgua);
        assertEquals(20, unCharacterDeAgua.getEnergy());
    }

    private void alimentar3Veces(Character character) throws CharacterFedMoreThan3TimesException {
        for (int i = 0; i < 3; i++) {
            character.feed();
        }
    }

    @Test(expected = CharacterFedMoreThan3TimesException.class)
    public void unPersonajeDeAguaEsAlimentadoMasDe3Veces() throws CharacterFedMoreThan3TimesException {
        alimentar3Veces(unCharacterDeAgua);
        unCharacterDeAgua.feed();
    }

    @Test
    public void unPersonajeDeTierraEsAlimentado() throws CharacterFedMoreThan3TimesException {
        unCharacterDeTierra.feed();
        assertEquals(8, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPerosnajeDeTierraEsAlimentado2Veces() throws CharacterFedMoreThan3TimesException {
        unCharacterDeTierra.feed();
        unCharacterDeTierra.feed();
        assertEquals(16, unCharacterDeTierra.getEnergy());
    }

    @Test
    public void unPersonajeDeFuegoEsAlimentado() throws CharacterFedMoreThan3TimesException {
        unCharacterDeFuego.withLife(new Life(10));
        unCharacterDeFuego.feed();
        assertEquals(25, unCharacterDeFuego.getLife());
    }

    @Test
    public void unPersonajeDeFuegoEsAlimentado9Veces() throws CharacterFedMoreThan3TimesException {
        for (int i = 0; i < 3; i++) {
            alimentar3Veces(unCharacterDeFuego);
        }
        assertEquals(100, unCharacterDeFuego.getLife());
    }

    @Test
    public void unPersonajeDeAireEsAlimentado() throws CharacterFedMoreThan3TimesException {
        unCharacterDeAire.withEnergy(new Energy(25));
        unCharacterDeAire.feed();
        assertEquals(25, unCharacterDeAire.getEnergy());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeAireSinEscudo() {
        unCharacterDeAguaCon20DeEnergia.attack(unCharacterDeAire);
        assertEquals(80, unCharacterDeAire.getLife());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeAireConUnEscudo() {
        unCharacterDeAire.setShield(new OneShield());
        unCharacterDeAguaCon20DeEnergia.attack(unCharacterDeAire);
        assertEquals(82, unCharacterDeAire.getLife());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeAireConDosEscudos() {
        unCharacterDeAire.setShield(new TwoShields());
        unCharacterDeAguaCon20DeEnergia.attack(unCharacterDeAire);
        assertEquals(84, unCharacterDeAire.getLife());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeAireConMasDeDosEscudos() {
        unCharacterDeAire.setShield(new MoreThanTwoShields());
        unCharacterDeAguaCon20DeEnergia.attack(unCharacterDeAire);
        assertEquals(96, unCharacterDeAire.getLife());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeFuegoSinEscudo() {
        unCharacterDeAguaCon20DeEnergia.attack(unCharacterDeFuego);
        assertEquals(70, unCharacterDeFuego.getLife());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeFuegoConEscudo() {
        unCharacterDeFuego.setShield(new OneShield());
        unCharacterDeAguaCon20DeEnergia.attack(unCharacterDeFuego);
        assertEquals(73, unCharacterDeFuego.getLife());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeFuegoConDosEscudos() {
        unCharacterDeFuego.setShield(new TwoShields());
        unCharacterDeAguaCon20DeEnergia.attack(unCharacterDeFuego);
        assertEquals(76, unCharacterDeFuego.getLife());
    }

    @Test
    public void unPersonajeDeAguaAtaqueAPersonajeDeFuegoConMasDeDosEscudos() {
        unCharacterDeFuego.setShield(new MoreThanTwoShields());
        unCharacterDeAguaCon20DeEnergia.attack(unCharacterDeFuego);
        assertEquals(94, unCharacterDeFuego.getLife());
    }

    @Test
    public void unPersonajeDeFuegoAtacaOtroPersonajeDeFuegoSinEscudo() {
        unCharacterDeFuego.clone().attack(unCharacterDeFuego);
        assertEquals(80, unCharacterDeFuego.getLife());
    }

    @Test
    public void unPersonajeDeFuegoAtacaAPersonajeDeAireSinEscudo() {
        unCharacterDeFuego.attack(unCharacterDeAire);
        assertEquals(70, unCharacterDeAire.getLife());
    }

    @Test
    public void unPersonajeDeFuegoAtacaAPersonajeDeAguaSinEscudo() {
        unCharacterDeFuego.attack(unCharacterDeAgua);
        assertEquals(90, unCharacterDeAgua.getLife());
    }

    @Test
    public void unPersonajeDeAireAtacaAPersonajeDeTierraSinEscudo() {
        unCharacterDeAire.attack(unCharacterDeTierra);
        assertEquals(80, unCharacterDeTierra.getLife());
    }

    @Test
    public void unPersonajeDeAireAtacaAPersonajeDeFuegoSinEscudo() {
        unCharacterDeAire.attack(unCharacterDeFuego);
        assertEquals(90, unCharacterDeFuego.getLife());
    }
}

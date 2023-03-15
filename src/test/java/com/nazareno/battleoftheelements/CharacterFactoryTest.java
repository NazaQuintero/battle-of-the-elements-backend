package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.character.Character;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.character.*;

import static org.junit.Assert.assertEquals;

public class CharacterFactoryTest {

    @Test
    public void seObtieneSiempreLaMismaInstanciaDePersonajeFactoryEnCadaGetInstance() {
        CharacterFactory factory1 = CharacterFactory.getInstance();
        CharacterFactory factory2 = CharacterFactory.getInstance();
        assertEquals(factory1, factory2);
    }

    @Test
    public void seObtieneUnPersonajeDeFuegoDeLaFactory() throws UnknownCharacterTypeException {
        CharacterFactory characterFactory = CharacterFactory.getInstance();
        Character character = characterFactory.getCharacter("FUEGO")
                .named("Wukong")
                .withEnergy(new Energy(10))
                .withLife(new Life(100));
        assertEquals("FUEGO", character.getType());
    }

    @Test(expected = UnknownCharacterTypeException.class)
    public void sePideUnPersonajeDeTipoRayo() throws UnknownCharacterTypeException {
        CharacterFactory.getInstance().getCharacter("RAYO")
                .named("Pikachu")
                .withEnergy(new Energy(10))
                .withLife(new Life(100));
    }
}

package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.exception.UnknownCharacterTypeException;
import com.nazareno.battleoftheelements.model.character.Character;
import org.junit.Test;
import com.nazareno.battleoftheelements.model.character.*;

import static com.nazareno.battleoftheelements.model.character.CharacterType.FIRE;
import static org.junit.Assert.assertEquals;

public class CharacterFactoryTest {

    @Test
    public void sameInstanceOfCharacterFactoryIsObtained() {
        CharacterFactory factory1 = CharacterFactory.getInstance();
        CharacterFactory factory2 = CharacterFactory.getInstance();
        assertEquals(factory1, factory2);
    }

    @Test
    public void aFireCharacterIsObtainedFromFactoryGivenCharacterType() throws UnknownCharacterTypeException {
        CharacterFactory characterFactory = CharacterFactory.getInstance();
        Character character = characterFactory.getCharacter(FIRE.toString())
                .named("Wukong")
                .withEnergy(new Energy(10))
                .withLife(new Life(100));
        assertEquals(FIRE.toString(), character.getType());
    }

    @Test(expected = UnknownCharacterTypeException.class)
    public void anUnknownCharacterTypeIsRequiredFromFactory() throws UnknownCharacterTypeException {
        CharacterFactory.getInstance().getCharacter("RAYO")
                .named("Pikachu")
                .withEnergy(new Energy(10))
                .withLife(new Life(100));
    }
}

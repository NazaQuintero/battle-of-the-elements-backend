package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.Menu;
import com.nazareno.battleoftheelements.model.character.Character;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.nazareno.battleoftheelements.model.character.*;

import java.util.Arrays;
import java.util.List;

import static com.nazareno.battleoftheelements.model.character.CharacterType.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class MenuTest {

    Menu menu;
    CharacterFactory factory;
    Character aCharacter;

    @Before
    public void init() throws UnknownCharacterTypeException {
        this.menu = new Menu();
        this.factory = CharacterFactory.getInstance();
        this.aCharacter = factory.getCharacter(FIRE.toString())
                .named("Wukong")
                .withEnergy(new Energy(20))
                .withLife(new Life(100));
    }

    @Test
    public void aCharacterIsAdded() {
        menu.addCharacter(aCharacter);
        assertEquals(1, menu.getCharactersQuantity());
    }

    @Test
    public void sameCharacterIsAddedTwice() {
        menu.addCharacter(aCharacter);
        menu.addCharacter(aCharacter);
        assertEquals(1, menu.getCharactersQuantity());
    }

    @Test
    @Parameters({"Wukong"})
    public void aCharacterIsObtainedByName(String characterName) {
        menu.addCharacter(aCharacter);
        assertEquals(aCharacter, menu.getCharacter(characterName));
    }

    @Test
    @Parameters({"Wukong"})
    public void aCharacterIsDeletedByName(String characterName) {
        menu.addCharacter(aCharacter);
        menu.deleteCharacter(characterName);
        assertEquals(0, menu.getCharactersQuantity());
    }

    @Test
    public void aCharacterIsFed() throws CharacterFedMoreThan3TimesException {
        Character character = mock(Character.class);
        menu.addCharacter(character);
        menu.feed(character.getName());
        verify(character, times(1)).feed();
    }

    @Test
    public void allCharactersNameAreRetrievedAsList() {
        List<String> expectedNames = Arrays.asList("Wukong", "Blitzcrank", "Varus");
        menu.addCharacter(aCharacter);
        menu.addCharacter(aCharacter.clone().named("Blitzcrank"));
        menu.addCharacter(aCharacter.clone().named("Varus"));
        assertEquals(expectedNames, menu.getCharactersNameAsList());
    }
}

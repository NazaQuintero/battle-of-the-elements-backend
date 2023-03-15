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

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class MenuTest {

    Menu menu;
    CharacterFactory factory;
    Character unCharacter;

    @Before
    public void init() throws UnknownCharacterTypeException {
        this.menu = new Menu();
        this.factory = CharacterFactory.getInstance();
        this.unCharacter = factory.getCharacter("FUEGO")
                .named("Wukong")
                .withEnergy(new Energy(20))
                .withLife(new Life(100));
    }

    @Test
    public void seAgregaUnPersonaje() {
        menu.addCharacter(unCharacter);
        assertEquals(1, menu.getCharactersQuantity());
    }

    @Test
    public void seAgrega2VecesElMismoPersonaje() {
        menu.addCharacter(unCharacter);
        menu.addCharacter(unCharacter);
        assertEquals(1, menu.getCharactersQuantity());
    }

    @Test
    @Parameters({"Wukong"})
    public void seObtieneUnPersonajePorNombre(String nombrePersonaje) {
        menu.addCharacter(unCharacter);
        assertEquals(unCharacter, menu.getCharacter(nombrePersonaje));
    }

    @Test
    @Parameters({"Wukong"})
    public void seBorraUnPersonajePorElNombre(String nombrePersonaje) {
        menu.addCharacter(unCharacter);
        menu.deleteCharacter(nombrePersonaje);
        assertEquals(0, menu.getCharactersQuantity());
    }

    @Test
    public void seAlimentaUnPersonaje() throws CharacterFedMoreThan3TimesException {
        Character character = mock(Character.class);
        menu.addCharacter(character);
        menu.feed(character.getName());
        verify(character, times(1)).feed();
    }

    @Test
    public void seObtieneElNombreDeTodosLosPersonajes() {
        List<String> nombresEsperados = Arrays.asList("Wukong", "Blitzcrank", "Varus");
        menu.addCharacter(unCharacter);
        menu.addCharacter(unCharacter.clone().named("Blitzcrank"));
        menu.addCharacter(unCharacter.clone().named("Varus"));
        assertEquals(nombresEsperados, menu.getCharactersNameAsList());
    }
}

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
        menu.agregarPersonaje(unCharacter);
        assertEquals(1, menu.getCantidadPersonajes());
    }

    @Test
    public void seAgrega2VecesElMismoPersonaje() {
        menu.agregarPersonaje(unCharacter);
        menu.agregarPersonaje(unCharacter);
        assertEquals(1, menu.getCantidadPersonajes());
    }

    @Test
    @Parameters({"Wukong"})
    public void seObtieneUnPersonajePorNombre(String nombrePersonaje) {
        menu.agregarPersonaje(unCharacter);
        assertEquals(unCharacter, menu.getPersonaje(nombrePersonaje));
    }

    @Test
    @Parameters({"Wukong"})
    public void seBorraUnPersonajePorElNombre(String nombrePersonaje) {
        menu.agregarPersonaje(unCharacter);
        menu.borrarPersonaje(nombrePersonaje);
        assertEquals(0, menu.getCantidadPersonajes());
    }

    @Test
    public void seAlimentaUnPersonaje() throws CharacterFedMoreThan3TimesException {
        Character character = mock(Character.class);
        menu.agregarPersonaje(character);
        menu.alimentar(character.getName());
        verify(character, times(1)).feed();
    }

    @Test
    public void seObtieneElNombreDeTodosLosPersonajes() {
        List<String> nombresEsperados = Arrays.asList("Wukong", "Blitzcrank", "Varus");
        menu.agregarPersonaje(unCharacter);
        menu.agregarPersonaje(unCharacter.clone().named("Blitzcrank"));
        menu.agregarPersonaje(unCharacter.clone().named("Varus"));
        assertEquals(nombresEsperados, menu.obtenerNombrePersonajes());
    }
}

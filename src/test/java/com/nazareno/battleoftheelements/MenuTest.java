package com.nazareno.battleoftheelements;

import com.nazareno.battleoftheelements.model.Menu;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.nazareno.battleoftheelements.model.personaje.*;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(JUnitParamsRunner.class)
public class MenuTest {

    Menu menu;
    PersonajeFactory factory;
    Personaje unPersonaje;

    @Before
    public void init() throws TipoDePersonajeDesconocidoException {
        this.menu = new Menu();
        this.factory = PersonajeFactory.getInstance();
        this.unPersonaje = factory.getPersonaje("FUEGO")
                .conNombre("Wukong")
                .conEnergia(new Energia(20))
                .conVida(new Vida(100));
    }

    @Test
    public void seAgregaUnPersonaje() {
        menu.agregarPersonaje(unPersonaje);
        assertEquals(1, menu.getCantidadPersonajes());
    }

    @Test
    public void seAgrega2VecesElMismoPersonaje() {
        menu.agregarPersonaje(unPersonaje);
        menu.agregarPersonaje(unPersonaje);
        assertEquals(1, menu.getCantidadPersonajes());
    }

    @Test
    @Parameters({"Wukong"})
    public void seObtieneUnPersonajePorNombre(String nombrePersonaje) {
        menu.agregarPersonaje(unPersonaje);
        assertEquals(unPersonaje, menu.getPersonaje(nombrePersonaje));
    }

    @Test
    @Parameters({"Wukong"})
    public void seBorraUnPersonajePorElNombre(String nombrePersonaje) {
        menu.agregarPersonaje(unPersonaje);
        menu.borrarPersonaje(nombrePersonaje);
        assertEquals(0, menu.getCantidadPersonajes());
    }

    @Test
    public void seAlimentaUnPersonaje() throws PersonajeAlimentadoMasDe3VecesException {
        Personaje personaje = mock(Personaje.class);
        menu.agregarPersonaje(personaje);
        menu.alimentar(personaje.getNombre());
        verify(personaje, times(1)).alimentar();
    }

    @Test
    public void seObtieneElNombreDeTodosLosPersonajes() {
        List<String> nombresEsperados = Arrays.asList("Wukong", "Blitzcrank", "Varus");
        menu.agregarPersonaje(unPersonaje);
        menu.agregarPersonaje(unPersonaje.clone().conNombre("Blitzcrank"));
        menu.agregarPersonaje(unPersonaje.clone().conNombre("Varus"));
        assertEquals(nombresEsperados, menu.obtenerNombrePersonajes());
    }
}

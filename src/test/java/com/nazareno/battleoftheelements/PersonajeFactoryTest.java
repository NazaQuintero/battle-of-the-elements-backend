package com.nazareno.battleoftheelements;

import org.junit.Test;
import com.nazareno.battleoftheelements.model.personaje.*;

import static org.junit.Assert.assertEquals;

public class PersonajeFactoryTest {

    @Test
    public void seObtieneSiempreLaMismaInstanciaDePersonajeFactoryEnCadaGetInstance() {
        PersonajeFactory factory1 = PersonajeFactory.getInstance();
        PersonajeFactory factory2 = PersonajeFactory.getInstance();
        assertEquals(factory1, factory2);
    }

    @Test
    public void seObtieneUnPersonajeDeFuegoDeLaFactory() throws TipoDePersonajeDesconocidoException {
        PersonajeFactory personajeFactory = PersonajeFactory.getInstance();
        Personaje personaje = personajeFactory.getPersonaje("FUEGO")
                .conNombre("Wukong")
                .conEnergia(new Energia(10))
                .conVida(new Vida(100));
        assertEquals("FUEGO", personaje.getTipo());
    }

    @Test(expected = TipoDePersonajeDesconocidoException.class)
    public void sePideUnPersonajeDeTipoRayo() throws TipoDePersonajeDesconocidoException {
        PersonajeFactory.getInstance().getPersonaje("RAYO")
                .conNombre("Pikachu")
                .conEnergia(new Energia(10))
                .conVida(new Vida(100));
    }
}

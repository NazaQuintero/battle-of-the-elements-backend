package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.personaje.Personaje;
import com.nazareno.battleoftheelements.model.personaje.PersonajeAlimentadoMasDe3VecesException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, Personaje> personajes = new HashMap<>();

    public void agregarPersonaje(Personaje unPersonaje) {
        this.personajes.putIfAbsent(unPersonaje.getNombre(), unPersonaje);
    }

    public int getCantidadPersonajes() {
        return this.personajes.size();
    }

    public Personaje getPersonaje(String nombrePersonaje) {
        return this.personajes.get(nombrePersonaje);
    }

    public void borrarPersonaje(String nombrePersonaje) {
        this.personajes.remove(nombrePersonaje);
    }

    public void alimentar(String nombrePersonaje) throws PersonajeAlimentadoMasDe3VecesException {
        this.personajes.get(nombrePersonaje).alimentar();
    }

    public List<String> obtenerNombrePersonajes() {
        return new ArrayList<>(this.personajes.keySet());
    }
}

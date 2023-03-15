package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.personaje.Character;
import com.nazareno.battleoftheelements.model.personaje.CharacterFedMoreThan3TimesException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, Character> personajes = new HashMap<>();

    public void agregarPersonaje(Character unCharacter) {
        this.personajes.putIfAbsent(unCharacter.getName(), unCharacter);
    }

    public int getCantidadPersonajes() {
        return this.personajes.size();
    }

    public Character getPersonaje(String nombrePersonaje) {
        return this.personajes.get(nombrePersonaje);
    }

    public void borrarPersonaje(String nombrePersonaje) {
        this.personajes.remove(nombrePersonaje);
    }

    public void alimentar(String nombrePersonaje) throws CharacterFedMoreThan3TimesException {
        this.personajes.get(nombrePersonaje).feed();
    }

    public List<String> obtenerNombrePersonajes() {
        return new ArrayList<>(this.personajes.keySet());
    }
}

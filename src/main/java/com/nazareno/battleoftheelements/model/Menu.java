package com.nazareno.battleoftheelements.model;

import com.nazareno.battleoftheelements.model.character.Character;
import com.nazareno.battleoftheelements.exception.CharacterFedMoreThan3TimesException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
    private Map<String, Character> characters = new HashMap<>();

    public void addCharacter(Character character) {
        this.characters.putIfAbsent(character.getName(), character);
    }

    public int getCharactersQuantity() {
        return this.characters.size();
    }

    public Character getCharacter(String characterName) {
        return this.characters.get(characterName);
    }

    public void deleteCharacter(String characterName) {
        this.characters.remove(characterName);
    }

    public void feed(String characterName) throws CharacterFedMoreThan3TimesException {
        this.characters.get(characterName).feed();
    }

    public List<String> getCharactersNameAsList() {
        return new ArrayList<>(this.characters.keySet());
    }
}

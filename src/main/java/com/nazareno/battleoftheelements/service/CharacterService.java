package com.nazareno.battleoftheelements.service;

import com.nazareno.battleoftheelements.model.character.Character;

import java.util.List;

public interface CharacterService {

    List<Character> findAll();

    Character findById(int id);

    Character save(Character character);

    void deleteById(int id);
}

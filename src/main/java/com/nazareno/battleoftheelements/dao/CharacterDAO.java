package com.nazareno.battleoftheelements.dao;

import com.nazareno.battleoftheelements.model.character.Character;

import java.util.List;

public interface CharacterDAO {

    List<Character> findAll();

    Character findById(int id);

    Character save(Character character);

    void deleteById(int id);
}

package com.nazareno.battleoftheelements.service;

import com.nazareno.battleoftheelements.dao.CharacterRepository;
import com.nazareno.battleoftheelements.model.character.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    private CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Character> findAll() {
        return characterRepository.findAll();
    }

    @Override
    public Character findById(int id) {
        Optional<Character> result = characterRepository.findById(id);

        Character character;

        if (result.isPresent()) {
            character = result.get();
        } else {
            throw new RuntimeException("Could not find character id - " + id);
        }
        return character;
    }

    @Override
    public Character save(Character character) {
        return characterRepository.save(character);
    }

    @Override
    public void deleteById(int id) {
        characterRepository.deleteById(id);
    }
}

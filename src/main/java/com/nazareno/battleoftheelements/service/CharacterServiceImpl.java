package com.nazareno.battleoftheelements.service;

import com.nazareno.battleoftheelements.dao.CharacterDAO;
import com.nazareno.battleoftheelements.model.character.Character;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private CharacterDAO characterDAO;

    @Autowired
    public CharacterServiceImpl(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    @Override
    public List<Character> findAll() {
        return characterDAO.findAll();
    }

    @Override
    public Character findById(int id) {
        return characterDAO.findById(id);
    }

    @Transactional
    @Override
    public Character save(Character character) {
        return characterDAO.save(character);
    }

    @Transactional
    @Override
    public void deleteById(int id) {
        characterDAO.deleteById(id);
    }
}

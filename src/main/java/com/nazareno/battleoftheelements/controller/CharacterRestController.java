package com.nazareno.battleoftheelements.controller;

import com.nazareno.battleoftheelements.exception.CharacterNotFoundException;
import com.nazareno.battleoftheelements.model.character.Character;
import com.nazareno.battleoftheelements.service.CharacterService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CharacterRestController {

    private CharacterService characterService;

    public CharacterRestController(CharacterService characterService) {
        this.characterService = characterService;
    }

    List<Character> characters = new ArrayList<>();

    @GetMapping("/characters")
    public List<Character> findAll() {
        return characterService.findAll();
    }

    @GetMapping("/characters/{characterId}")
    public Character getCharacter(@PathVariable int characterId) {
        Character character = characterService.findById(characterId);

        if (character == null) {
            throw new CharacterNotFoundException("Character id not found - " + characterId);
        }

        return character;
    }

    @PostMapping("/characters")
    public Character addCharacter(@RequestBody Character character) {
        character.setId(0);
        return characterService.save(character);
    }

    @PutMapping("/characters")
    public Character updateCharacter(@RequestBody Character character) {
        return characterService.save(character);
    }

    @DeleteMapping("/characters/{characterId}")
    public String deleteCharacter(@PathVariable int characterId) {
        Character tempCharacter = characterService.findById(characterId);

        if (tempCharacter == null) {
            throw new RuntimeException("Character id not found - " + characterId);
        }

        characterService.deleteById(characterId);

        return "Deleted character id - " + characterId;
    }

}

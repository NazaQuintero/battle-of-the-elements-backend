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

}

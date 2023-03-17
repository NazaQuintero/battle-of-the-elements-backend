package com.nazareno.battleoftheelements.dao;

import com.nazareno.battleoftheelements.model.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Integer> {
}

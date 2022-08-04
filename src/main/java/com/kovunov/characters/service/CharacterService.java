package com.kovunov.characters.service;

import com.kovunov.characters.model.Character;

import java.util.List;

public interface CharacterService {
    List<Character> getCharacters();
    Character getCharacterById(Long id);
    Character createCharacter(Character character);
    Character updateCharacter(Long id, Character character);
    void deleteCharacter(Long id);
}

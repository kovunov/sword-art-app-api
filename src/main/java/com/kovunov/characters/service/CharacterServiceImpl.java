package com.kovunov.characters.service;

import com.kovunov.characters.model.Character;
import com.kovunov.characters.repo.CharactersRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private CharactersRepository charactersRepository;

    public CharacterServiceImpl(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @Override
    public List<Character> getCharacters() {
        List<Character> characters = new ArrayList<>();
        charactersRepository.findAll().forEach(characters::add);
        return characters;
    }

    @Override
    public Character getCharacterById(Long id) {
        return charactersRepository.findById(id).orElse( null );
    }

    @Override
    public Character createCharacter(Character character) {
        return charactersRepository.save(character);
    }

    @Override
    public Character updateCharacter(Long id, Character character) {
        Character updatedCharacter = charactersRepository.findById(id).orElse( null );
        if (updatedCharacter != null) {
            updatedCharacter.setName(character.getName());
            updatedCharacter.setHealth(character.getHealth());
            updatedCharacter.setFraction(character.getFraction());
            updatedCharacter.setDamagePerHit(character.getDamagePerHit());
            updatedCharacter.setWeapon(character.getWeapon());
            return charactersRepository.save(updatedCharacter);
        }
        return null;
    }

    @Override
    public void deleteCharacter(Long id) {
        charactersRepository.deleteById(id);
    }
}

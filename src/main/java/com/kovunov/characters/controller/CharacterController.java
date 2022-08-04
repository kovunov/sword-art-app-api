package com.kovunov.characters.controller;

import com.kovunov.characters.model.Character;
import com.kovunov.characters.service.CharacterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<Character>> getCharacters() {
        return new ResponseEntity<>(characterService.getCharacters(), HttpStatus.OK);
    }

    @PostMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Character> createCharacter(@RequestBody Character character) {
        return new ResponseEntity<>(characterService.createCharacter(character), HttpStatus.OK);
    }

    @PutMapping({"/{id}"})
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Character> updateCharacter(@PathVariable Long id, @RequestBody Character character) {
        return new ResponseEntity<>(characterService.updateCharacter(id, character), HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> deleteCharacter(@PathVariable Long id) {
        characterService.deleteCharacter(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

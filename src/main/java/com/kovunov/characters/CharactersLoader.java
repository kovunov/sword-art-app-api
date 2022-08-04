package com.kovunov.characters;

import com.kovunov.characters.model.Character;
import com.kovunov.characters.repo.CharactersRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CharactersLoader implements CommandLineRunner {
    private CharactersRepository charactersRepository;

    public CharactersLoader(CharactersRepository charactersRepository) {
        this.charactersRepository = charactersRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadCharacters();
    }

    private void loadCharacters() {
        if (charactersRepository.count() == 0) {
            charactersRepository.save(Character.builder().name("Goku")
                    .health(100)
                    .fraction("Saiyajin")
                    .damagePerHit(10)
                    .weapon("Kamehameha")
                    .build());

            charactersRepository.save(Character.builder().name("Naruto")
                    .health(135)
                    .fraction("Uzumaki")
                    .damagePerHit(15)
                    .weapon("Kurama")
                    .build());
        }
    }
}

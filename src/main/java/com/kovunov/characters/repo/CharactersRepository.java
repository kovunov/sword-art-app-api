package com.kovunov.characters.repo;

import com.kovunov.characters.model.Character;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharactersRepository extends CrudRepository<Character, Long> {
}

package io.github.katarem.genshin_api.domain.port;

import java.util.List;

import io.github.katarem.genshin_api.domain.model.Character;

public interface CharacterPersistencePort {
    List<Character> getAll();

    Character createNew(Character character);

    Character getById(Long id);

    Character update(Character character, Long id);

    void delete(Long id);

}

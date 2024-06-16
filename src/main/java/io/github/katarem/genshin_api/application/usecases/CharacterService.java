package io.github.katarem.genshin_api.application.usecases;

import java.util.List;

import io.github.katarem.genshin_api.domain.dto.CharacterDto;
import io.github.katarem.genshin_api.domain.request.CharacterRequest;

public interface CharacterService {

    List<CharacterDto> getAll();

    CharacterDto getById(Long id);

    CharacterDto create(CharacterRequest request);

    void deleteById(Long id);

    CharacterDto update(CharacterRequest request, Long id);
}

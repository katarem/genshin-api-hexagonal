package io.github.katarem.genshin_api.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.katarem.genshin_api.application.mapper.CharacterDtoMapper;
import io.github.katarem.genshin_api.application.mapper.CharacterRequestMapper;
import io.github.katarem.genshin_api.application.usecases.CharacterService;
import io.github.katarem.genshin_api.domain.dto.CharacterDto;
import io.github.katarem.genshin_api.domain.port.CharacterPersistencePort;
import io.github.katarem.genshin_api.domain.request.CharacterRequest;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterPersistencePort persistencePort;
    private final CharacterRequestMapper requestMapper;
    private final CharacterDtoMapper dtoMapper;

    public CharacterServiceImpl(
            final CharacterPersistencePort persistencePort,
            final CharacterRequestMapper requestMapper,
            final CharacterDtoMapper dtoMapper) {
        this.persistencePort = persistencePort;
        this.requestMapper = requestMapper;
        this.dtoMapper = dtoMapper;
    }

    @Override
    public List<CharacterDto> getAll() {
        return persistencePort.getAll()
                .stream()
                .map(dtoMapper::toDto)
                .toList();
    }

    @Override
    public CharacterDto getById(Long id) {
        var character = persistencePort.getById(id);
        return dtoMapper.toDto(character);
    }

    @Override
    public CharacterDto create(CharacterRequest request) {
        var character = requestMapper.toDomain(request);
        persistencePort.createNew(character);
        return dtoMapper.toDto(character);
    }

    @Override
    public void deleteById(Long id) {
        persistencePort.delete(id);
    }

    @Override
    public CharacterDto update(CharacterRequest request, Long id) {
        var forUpdate = requestMapper.toDomain(request);
        var updatedCharacter = persistencePort.update(forUpdate, id);
        return dtoMapper.toDto(updatedCharacter);
    }

}
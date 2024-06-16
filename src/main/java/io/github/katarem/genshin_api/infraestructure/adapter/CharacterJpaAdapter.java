package io.github.katarem.genshin_api.infraestructure.adapter;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.katarem.genshin_api.domain.model.Character;
import io.github.katarem.genshin_api.domain.port.CharacterPersistencePort;
import io.github.katarem.genshin_api.infraestructure.mapper.CharacterDboMapper;
import io.github.katarem.genshin_api.infraestructure.repository.CharacterRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CharacterJpaAdapter implements CharacterPersistencePort {

    private final CharacterDboMapper dboMapper;
    private final CharacterRepository repository;

    public CharacterJpaAdapter(CharacterDboMapper dboMapper, CharacterRepository repository) {
        this.dboMapper = dboMapper;
        this.repository = repository;
    }

    @Override
    public List<Character> getAll() {
        return repository.findAll()
                .stream()
                .map(dboMapper::toDomain)
                .toList();
    }

    @Override
    public Character createNew(Character character) {
        var characterToSave = dboMapper.toDbo(character);
        var characterToReturn = repository.save(characterToSave);
        return dboMapper.toDomain(characterToReturn);
    }

    @Override
    public Character getById(Long id) {
        var character = repository.findById(id).orElseThrow();
        return dboMapper.toDomain(character);
    }

    @Override
    public Character update(Character character, Long id) {
        if (repository.findById(id).isPresent()) {
            var characterToUpdate = dboMapper.toDbo(character);
            characterToUpdate.setId(id);
            var updated = repository.save(characterToUpdate);
            return dboMapper.toDomain(updated);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

}

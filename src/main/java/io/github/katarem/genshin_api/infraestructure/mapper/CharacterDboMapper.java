package io.github.katarem.genshin_api.infraestructure.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.katarem.genshin_api.infraestructure.entity.CharacterEntity;
import io.github.katarem.genshin_api.domain.model.Character;

@Mapper(componentModel = "spring")
public interface CharacterDboMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "element", target = "element")
    @Mapping(source = "weapon", target = "weapon")
    @Mapping(source = "releaseDate", target = "releaseDate")
    CharacterEntity toDbo(Character domain);

    @InheritInverseConfiguration
    Character toDomain(CharacterEntity dbo);
}

package io.github.katarem.genshin_api.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import io.github.katarem.genshin_api.domain.dto.CharacterDto;
import io.github.katarem.genshin_api.domain.model.Character;

@Mapper(componentModel = "spring")
public interface CharacterDtoMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "element", target = "element")
    @Mapping(source = "weapon", target = "weapon")
    @Mapping(source = "releaseDate", target = "releaseDate")
    CharacterDto toDto(Character character);
}
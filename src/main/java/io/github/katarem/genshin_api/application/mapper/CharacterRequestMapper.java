package io.github.katarem.genshin_api.application.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import io.github.katarem.genshin_api.domain.model.Character;
import io.github.katarem.genshin_api.domain.request.CharacterRequest;

@Mapper(componentModel = "spring")
public interface CharacterRequestMapper {

    @Mapping(source = "name", target = "name")
    @Mapping(source = "element", target = "element")
    @Mapping(source = "weapon", target = "weapon")
    @Mapping(source = "releaseDate", target = "releaseDate")
    Character toDomain(CharacterRequest request);
}
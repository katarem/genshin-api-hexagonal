package io.github.katarem.genshin_api.infraestructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.katarem.genshin_api.infraestructure.entity.CharacterEntity;

public interface CharacterRepository extends JpaRepository<CharacterEntity, Long> {

}

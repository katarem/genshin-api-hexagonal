package io.github.katarem.genshin_api.infraestructure.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.katarem.genshin_api.application.usecases.CharacterService;
import io.github.katarem.genshin_api.domain.dto.CharacterDto;
import io.github.katarem.genshin_api.domain.request.CharacterRequest;

@RestController
@RequestMapping("/api/character")
public class CharacterController {

    final CharacterService service;

    public CharacterController(CharacterService service) {
        this.service = service;
    }

    @GetMapping
    public List<CharacterDto> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public CharacterDto getCharacter(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    @PostMapping
    public CharacterDto createCharacter(@RequestBody CharacterRequest character) {
        return service.create(character);
    }

    @PostMapping("/all")
    public String createAll(@RequestBody List<CharacterRequest> characters) {
        characters.forEach(service::create);
        return "creados correctamente";
    }

    @PutMapping("/{id}")
    public CharacterDto updateCharacter(
            @RequestBody CharacterRequest characterRequest,
            @PathVariable("id") Long id) {
        var updated = service.update(characterRequest, id);
        return updated != null ? updated : new CharacterDto();
    }

    @DeleteMapping("/{id}")
    public void deleteCharacter(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}

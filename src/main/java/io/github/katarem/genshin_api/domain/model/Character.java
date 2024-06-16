package io.github.katarem.genshin_api.domain.model;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Character {
    private Long id;
    private String name;
    private Element element;
    private Date releaseDate;
    private Weapon weapon;
}
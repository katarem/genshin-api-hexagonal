package io.github.katarem.genshin_api.domain.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CharacterDto {
    private Long id;
    private String name;
    private String weapon;
    private String element;
    private Date releaseDate;
}

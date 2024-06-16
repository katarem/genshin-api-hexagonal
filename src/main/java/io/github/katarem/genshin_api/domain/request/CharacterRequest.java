package io.github.katarem.genshin_api.domain.request;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterRequest {
    private String name;
    private String element;
    private String weapon;
    private Date releaseDate;
}

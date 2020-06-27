package net.urflix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class Genres {
    @JsonProperty("genres")
    List<Genre> genreList;
}

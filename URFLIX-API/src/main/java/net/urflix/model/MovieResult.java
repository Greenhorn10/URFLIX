package net.urflix.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class MovieResult {

    boolean adult;
    int id;
    String imdb_id;
    List<GenreItem> genres;
    String original_title;
    String overview;
    String poster_path;
    int runtime;

    @Override
    public String toString() {
        // return "" + adult + (genres != null ? genres.size() : -1);
        return id + ";" + imdb_id + ";" + original_title + ";"; // + genres.size();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    private static class GenreItem {
        int id;
        String name;
    }
}

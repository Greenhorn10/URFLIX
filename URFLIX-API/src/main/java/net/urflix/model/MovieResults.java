package net.urflix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
public class MovieResults {
    @JsonProperty("page")
    Integer page;

    @JsonProperty("total_results")
    Long total_results;

    @JsonProperty("total_pages")
    Long total_pages;

    @JsonProperty("results")
    List<Movie> results;
}

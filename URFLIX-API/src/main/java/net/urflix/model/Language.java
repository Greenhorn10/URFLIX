package net.urflix.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("spoken_language")
public class Language {


    @JsonProperty("iso_639_1")
    private String isoCode;
    @JsonProperty("name")
    private String name;
}

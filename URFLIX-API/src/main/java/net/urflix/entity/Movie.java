package net.urflix.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
@Data
public class Movie {
    @Id
    @Column(name = "movie_id")
    private Long movieId;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}

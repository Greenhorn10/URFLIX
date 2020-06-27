package net.urflix.service;

import java.util.List;

public interface MovieDbService<T> {
    List<T> fetchMovieList();

    T fetchMovieById(Long id);

    List<T> fetchMoviesBySearchQuery(String query);
}

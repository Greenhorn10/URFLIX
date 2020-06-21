package net.urflix.service;

import net.urflix.model.MovieDto;

import java.util.List;
import java.util.Optional;

public interface MovieService<T> {
   Long save(T t);

   List<T> fetchAll();

   Optional<T> fetchById(Long id);
}

package net.urflix.controller;

import net.urflix.model.MovieDto;
import net.urflix.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @GetMapping("/all")
    public List<MovieDto> fetchAllMovies(){
        return movieService.fetchAll();
    }

    @GetMapping("/{id}")
    public Optional<MovieDto> fetchById(@PathVariable(value = "id")Long id){
        return movieService.fetchById(id);
    }

    @PostMapping
    public Long saveMovie(MovieDto movieDto){
        return movieService.save(movieDto);
    }
}

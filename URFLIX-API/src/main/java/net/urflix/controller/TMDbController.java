package net.urflix.controller;

import net.urflix.model.Genre;
import net.urflix.model.Movie;
import net.urflix.service.impl.TMDbServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tmdb")
@CrossOrigin
public class TMDbController {
    @Autowired
    private TMDbServiceImpl movieService;

    @GetMapping
    public List<Movie> getAllTopRatedMovies(){
       return movieService.fetchMovieList();
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Long id){
        return movieService.fetchMovieById(id);
    }

    @GetMapping("/genres")
    public List<Genre> getGenres(){
        return movieService.getGenres();
    }

    @GetMapping("/search")
    public List<Movie> getMovieSearchResult(@RequestParam("query") String query){
        return movieService.fetchMoviesBySearchQuery(query);
    }
}

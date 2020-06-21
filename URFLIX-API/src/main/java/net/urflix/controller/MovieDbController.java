package net.urflix.controller;

import net.urflix.model.MovieDbDto;
import net.urflix.service.MovieDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/moviedb")
public class MovieDbController {
    @Autowired
    private MovieDBService movieDBService;

    @GetMapping
    public MovieDbDto getMovieByTitleOrId(@RequestParam(name = "movie-id", required = false) String movieId,
                                          @RequestParam(name = "title", required = false) String title) {
        return movieDBService.getMovieByTitleOrId(movieId, title);
    }
}

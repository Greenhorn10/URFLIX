package net.urflix.service.impl;


import net.urflix.model.Genre;
import net.urflix.model.Genres;
import net.urflix.model.Movie;
import net.urflix.model.MovieResults;
import net.urflix.service.MovieDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class TMDbServiceImpl implements MovieDbService<Movie> {
    @Value("${tmdb-api-key}")
    private String tmdbApiKey;

    @Value("${tmdb.base.url}")
    private String tmdbBaseUrl;

    @Value("${tmdb.top.rated.movie.url}")
    private String topRatedMovieUrl;

    @Value("${tmdb.search.movie}")
    private String tmdbSearchMovieUrl;

    @Value("${tmdb.genre}")
    private String tmdbGenreUrl;

    @Autowired
    private RestTemplate restTemplate;


    @Override
    public List<Movie> fetchMovieList() {
        UriComponents uriComponents =
                UriComponentsBuilder.fromUriString(topRatedMovieUrl).build()
                        .expand(tmdbBaseUrl, tmdbApiKey)
                        .encode();

        URI uri = uriComponents.toUri();
        MovieResults movieResults = restTemplate.getForObject(uri, MovieResults.class);
        return movieResults.getResults();
    }

    @Override
    public Movie fetchMovieById(Long id) {
        return null;
    }

    @Override
    public List<Movie> fetchMoviesBySearchQuery(String query) {
        UriComponents uriComponents =
                UriComponentsBuilder.fromUriString(tmdbSearchMovieUrl).build()
                        .expand(tmdbBaseUrl, tmdbApiKey, query)
                        .encode();

        URI uri = uriComponents.toUri();

        MovieResults movieResults = restTemplate.getForObject(uri,MovieResults.class);
        return movieResults.getResults();
    }

    public List<Genre> getGenres(){
        UriComponents uriComponents =
                UriComponentsBuilder.fromUriString(tmdbGenreUrl).build()
                        .expand(tmdbBaseUrl, tmdbApiKey)
                        .encode();

        URI uri = uriComponents.toUri();
        Genres genres = restTemplate.getForObject(uri, Genres.class);
        return genres.getGenreList();
    }


}

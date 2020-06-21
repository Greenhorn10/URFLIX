package net.urflix.service;

import net.urflix.model.MovieResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TheMovieDBService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${movie-db-key}")
    private String movieDbKey;

    private static final String MOVIE_DB_API_URL = "http://api.themoviedb.org/3/movie/{id}?api_key={apikey}";

    public String fetchMovies(){
        MovieResult response = restTemplate.getForObject(MOVIE_DB_API_URL,
                MovieResult.class, 76341, movieDbKey);
        return response.toString();
    }
}

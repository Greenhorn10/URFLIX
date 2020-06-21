package net.urflix.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import net.urflix.model.MovieDbDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieDBService {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${omdb-api-key}")
    private String apiKey;

    @HystrixCommand(fallbackMethod = "defaultMovie")
    public MovieDbDto getMovieByTitleOrId(String imdbId, String title) {
        StringBuilder omdbApi = new StringBuilder("http://www.omdbapi.com/?apikey=");
        omdbApi.append(apiKey);

        if (!isEmptyString(imdbId)) {
            omdbApi.append("&i=").append(imdbId);
        }
        if (!isEmptyString(title)) {
            omdbApi.append("&t=").append(title);
        }
        omdbApi.append("&type=movie");
        ResponseEntity<MovieDbDto> movieDbResponse = restTemplate.getForEntity(omdbApi.toString(), MovieDbDto.class);
        return movieDbResponse.getBody();
    }

    public MovieDbDto defaultMovie(String imdbId, String title){
        return new MovieDbDto();
    }

    boolean isEmptyString(String string) {
        return string == null || string.isEmpty();
    }
}

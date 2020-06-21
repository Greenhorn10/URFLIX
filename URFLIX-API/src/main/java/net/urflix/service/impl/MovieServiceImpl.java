package net.urflix.service.impl;

import net.urflix.entity.Movie;
import net.urflix.model.MovieDto;
import net.urflix.repository.MovieRepository;
import net.urflix.service.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service(value = "movieService")
public class MovieServiceImpl implements MovieService<MovieDto> {
    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Long save(MovieDto movieDto) {
        Movie movie = modelMapper.map(movieDto, Movie.class);
        Movie savedMovie = movieRepository.save(movie);
        return savedMovie.getMovieId();
    }

    @Override
    public List<MovieDto> fetchAll() {
        return StreamSupport.stream(movieRepository.findAll().spliterator(),false)
                .map(movie -> modelMapper.map(movie, MovieDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDto> fetchById(Long id) {
        return movieRepository.findById(id).map(movie -> modelMapper.map(movie, MovieDto.class));
    }
}

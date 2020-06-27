package net.urflix.service.impl;

import net.urflix.entity.MovieEntity;
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
        MovieEntity movieEntity = modelMapper.map(movieDto, MovieEntity.class);
        MovieEntity savedMovieEntity = movieRepository.save(movieEntity);
        return savedMovieEntity.getMovieId();
    }

    @Override
    public List<MovieDto> fetchAll() {
        return StreamSupport.stream(movieRepository.findAll().spliterator(),false)
                .map(movieEntity -> modelMapper.map(movieEntity, MovieDto.class)).collect(Collectors.toList());
    }

    @Override
    public Optional<MovieDto> fetchById(Long id) {
        return movieRepository.findById(id).map(movieEntity -> modelMapper.map(movieEntity, MovieDto.class));
    }
}

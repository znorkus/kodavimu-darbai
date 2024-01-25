package lt.techin.demo.services;


import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public List<Movie> findAll() {
        return this.movieRepository.findAll();
    }

    public Movie findById(long id) {
        return this.movieRepository.findById(id).orElseThrow();
    }

}

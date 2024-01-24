package lt.techin.demo.controllers;


//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import jakarta.persistence.Id;

import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//import java.util.ArrayList;
//import java.util.List;

@RestController
public class MovieController {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable long id) {
        return this.movieRepository.findById(id).orElseThrow();
    }

    @PostMapping("/movies")
    public void insertMovie(@RequestBody Movie movie) {
        this.movieRepository.save(movie);
    }

    @PutMapping("/movies/{id}")
    public void updateMovie(@RequestBody Movie movie, @PathVariable long id) {
        if (this.movieRepository.existsById(id)) {
            Movie movieFromDb = this.movieRepository.findById(id).orElseThrow();

            movieFromDb.setDirector(movie.getDirector());
            movieFromDb.setTitle(movie.getTitle());
            movieFromDb.setLengthMinutes(movie.getLengthMinutes());
            movieFromDb.setYearRelease(movie.getLengthMinutes());

            this.movieRepository.save(movieFromDb);
        }

        this.movieRepository.save(movie);
    }
}
//    @GetMapping("/movies")
//    public List<Movie> getMovies() {
//        return this.movieRepository.findAll();
//    }

//    @GetMapping("/movies/{index}")
//    public Movie getMovie(@PathVariable int index) {
//        return null;
//    }


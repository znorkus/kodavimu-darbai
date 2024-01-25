package lt.techin.demo.controllers;

import lt.techin.demo.models.Movie;
import lt.techin.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return this.movieService.findAllMovies();
    }

    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable long id) {
        return this.movieService.findMovieById(id);
    }

    @PostMapping("/movies")
    public Movie insertMovie(@RequestBody Movie movie) {
        return this.movieService.saveMovie(movie);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@RequestBody Movie movie, @PathVariable long id) {
        if (this.movieService.existsMovieById(id)) {
            Movie movieFromDb = this.movieService.findMovieById(id);

            movieFromDb.setDirector(movie.getDirector());
            movieFromDb.setTitle(movie.getTitle());
            movieFromDb.setLengthMinutes(movie.getLengthMinutes());
            movieFromDb.setYearRelease(movie.getLengthMinutes());

            return this.movieService.saveMovie(movieFromDb);
        }
        return this.movieService.saveMovie(movie);
    }

    @DeleteMapping("/movies/{id}")
    public void deleteMovie(@PathVariable long id) {
        this.movieService.deleteMovieById(id);
    }
}
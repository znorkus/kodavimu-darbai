package lt.techin.demo.controllers;

import lt.techin.demo.models.Movie;
import lt.techin.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
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
    public ResponseEntity<Movie> insertMovie(@RequestBody Movie movie) {
        Movie savedMovie = this.movieService.saveMovie(movie);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedMovie.getId())
                        .toUri())
                .body(savedMovie);

    }
//    public Movie insertMovie(@RequestBody Movie movie) {
//        return this.movieService.saveMovie(movie);
//    }

//    @PutMapping("/movies/{id}")
////    public Movie updateMovie(@RequestBody Movie movie, @PathVariable long id) {
//    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie, @PathVariable long id) {
//        if (this.movieService.existsMovieById(id)) {
//            Movie movieFromDb = this.movieService.findMovieById(id);
//
//            movieFromDb.setDirector(movie.getDirector());
//            movieFromDb.setTitle(movie.getTitle());
//            movieFromDb.setLengthMinutes(movie.getLengthMinutes());
//            movieFromDb.setYearRelease(movie.getYearRelease());
//
//            this.movieService.saveMovie(movieFromDb);
//            return ResponseEntity.ok(movieFromDb);
//        }
//        Movie updatedMovie = this.movieService.saveMovie(movie);
//
//        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
//                        .path("/{id}").buildAndExpand(updatedMovie.getId())
//                        .toUri())
//                .body(updatedMovie);
//    }

    @DeleteMapping("/movies/{id}")
//    public void deleteMovie(@PathVariable long id) {
//        this.movieService.deleteMovieById(id);
    public ResponseEntity<Void> deleteMovie(@PathVariable long id) {
        if (this.movieService.existsMovieById(id)) {
            this.movieService.deleteMovieById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
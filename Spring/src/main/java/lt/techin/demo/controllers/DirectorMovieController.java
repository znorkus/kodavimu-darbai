package lt.techin.demo.controllers;


import lt.techin.demo.models.*;
import lt.techin.demo.repositories.DirectorMovieRepository;
import lt.techin.demo.services.DirectorMovieService;
import lt.techin.demo.services.DirectorService;
import lt.techin.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectorMovieController {

    private final DirectorMovieRepository directorMovieRepository;
    private final DirectorService directorService;
    private final DirectorMovieService directorMovieService;
    private final MovieService movieService;

    @Autowired
    public DirectorMovieController(DirectorMovieRepository directorMovieRepository,
                                   DirectorService directorService, DirectorMovieService directorMovieService, MovieService movieService) {
        this.directorMovieRepository = directorMovieRepository;
        this.directorService = directorService;
        this.directorMovieService = directorMovieService;
        this.movieService = movieService;
    }

    @GetMapping("/directorsmovies")
    public List<DirectorMovie> getDirectorsMovies() {
        return this.directorMovieRepository.findAll();
    }

    @GetMapping("/directors/{directorId}/movies/{movieId}")
    public DirectorMovie getDirectorMovie(@PathVariable("directorId") long directorId,
                                          @PathVariable("movieId") long movieId) {
        Director director = this.directorService.findDirectorById(directorId);
        Movie movie = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieId = new DirectorMovieId(director, movie);

        return this.directorMovieRepository.findById(directorMovieId).orElse(null);
    }

    @PostMapping("/directorsmovies")
    public DirectorMovie saveDirectorMovie(@RequestBody DirectorMovie directorMovie) {
        return this.directorMovieRepository.save(directorMovie);
    }

    @PutMapping("/directors/{directorId}/movies/{movieId}")
    public ResponseEntity<DirectorMovie> updateDirectorMovie(
            @PathVariable("directorId") long directorId,
            @PathVariable("movieId") long movieId,
            @RequestBody DirectorMovie directorMoviePayload) {

        Director directorFromDb = this.directorService.findDirectorById(directorId);
        Movie movieFromDb = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieIdPayload = new DirectorMovieId(directorFromDb, movieFromDb);

        if (this.directorMovieService.existsDirectorMovieById(directorMovieIdPayload)) {
            this.directorMovieService.deleteDirectorMovieById(directorMovieIdPayload);

            return ResponseEntity.ok(this.directorMovieService.saveDirectorMovie(directorMoviePayload));
        }
        return null;
    }

    @DeleteMapping("/directors/{directorId}/movies/{movieId}")
    public ResponseEntity<Void> deleteDirectorMovie(
            @PathVariable("directorId") long directorId,
            @PathVariable("movieId") long movieId) {

        Director directorFromDb = this.directorService.findDirectorById(directorId);
        Movie movieFromDb = this.movieService.findMovieById(movieId);
        DirectorMovieId directorMovieIdPayload = new DirectorMovieId(directorFromDb, movieFromDb);

        if (this.directorMovieService.existsDirectorMovieById(directorMovieIdPayload)) {
            this.directorMovieService.deleteDirectorMovieById(directorMovieIdPayload);

            return ResponseEntity.noContent().build();

        }

        return ResponseEntity.notFound().build();
    }
}

//    @DeleteMapping("/directors/{directorId}/movies/{movieId}")
//    public void deleteDirectorMovie(@PathVariable long id) {
//        this.directorService.deleteDirectorById(id);
//    }

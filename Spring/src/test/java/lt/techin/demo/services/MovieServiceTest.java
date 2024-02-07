package lt.techin.demo.services;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional //ištrina iš db lentelės po testo
@ActiveProfiles("test")
public class MovieServiceTest {

    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private MovieService movieService;

    @Test
        //Given
    void findAllMovies_saveMovies_returned() {
        Movie savedMovie1 = movieRepository.save(new Movie("Madagascar", "Stephen Spielberg", LocalDate.of(2005, 1, 1),
                (short) 60));
        Movie savedMovie2 = movieRepository.save(new Movie("Home Alone", "Stephen Spielberg", LocalDate.of(1999, 1, 1),
                (short) 120));
        //When
        List<Movie> movies = this.movieService.findAllMovies();
//Then
        then(movies).containsExactly(savedMovie1, savedMovie2);

    }

    @Test
    void findMovieById_saveMovies_returned() {
        Movie savedMovie1 = movieRepository.save(new Movie("Madagascar", "Stephen Spielberg", LocalDate.of(2000, 1, 1),
                (short) 60));
        Movie savedMovie2 = movieRepository.save(new Movie("Home Alone", "Stephen Spielberg", LocalDate.of(2001, 1, 1),
                (short) 120));
        //When
        Movie movieFromDb = this.movieService.findMovieById(savedMovie1.getId());
//Then
        then(movieFromDb).isEqualTo(savedMovie1);

    }

    @Test
    void findMovieById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(
                () -> this.movieService.findMovieById(1));

        then(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void saveMovie_saveIt_thenReturn() {
        Movie savedMovie = this.movieService
                .saveMovie(new Movie("Mr. Bean", "Rowan Atkinson",
                        LocalDate.of(2000, 1, 1), (short) 97));

        Movie foundMovie = this.movieRepository
                .findById(savedMovie.getId()).orElse(null);
    }

    @Test
    void existsMovieById_checkIfExists_returnTrue() {
        Movie savedMovie = this.movieRepository.save(new Movie("Avatar",
                "Clint Eastwood", LocalDate.of(2022, 1, 1), (short) 120));

        boolean existsMovie = this.movieService
                .existsMovieById(savedMovie.getId());

        then(existsMovie).isTrue();
    }

    @Test
    void deleteMovieById_delete_cannotFind() {
        Movie savedMovie = this.movieRepository.save(new Movie("Broken Flowers",
                "Jim Jarmusch", LocalDate.of(1999, 1, 1), (short) 101));
        this.movieService.deleteMovieById(savedMovie.getId());

        then(this.movieRepository.existsById(savedMovie.getId())).isFalse();
    }

}
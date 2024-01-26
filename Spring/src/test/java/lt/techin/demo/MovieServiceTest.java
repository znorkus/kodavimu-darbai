package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import lt.techin.demo.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

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
        Movie savedMovie1 = movieRepository.save(new Movie("Madagascar", "Stephen Spielberg", (short) 2005,
                (short) 60));
        Movie savedMovie2 = movieRepository.save(new Movie("Home Alone", "Stephen Spielberg", (short) 1999,
                (short) 120));
        //When
        List<Movie> movies = this.movieService.findAllMovies();
//Then
        then(movies).containsExactly(savedMovie1, savedMovie2);

    }

    @Test
    void findMovieById_saveMovies_returned() {
        Movie savedMovie1 = movieRepository.save(new Movie("Madagascar", "Stephen Spielberg", (short) 2005,
                (short) 60));
        Movie savedMovie2 = movieRepository.save(new Movie("Home Alone", "Stephen Spielberg", (short) 1999,
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
                .saveMovie(new Movie("Mr. Bean", "Rowant Atkinson", (short) 2019, (short) 97));

        Movie foundMovie = this.movieRepository
                .findById(savedMovie.getId()).orElse(null);
    }
}
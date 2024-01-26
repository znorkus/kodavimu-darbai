package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import lt.techin.demo.services.MovieService;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
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
        //given
    void findAllMovies_saveMovies_returned() {
        Movie savedMovie1 = movieRepository.save(new Movie("Madagascar", "Stephen Spielberg", (short) 2005,
                (short) 60));
        Movie savedMovie2 = movieRepository.save(new Movie("Home Alone", "Stephen Spielberg", (short) 1999,
                (short) 120));
        //When
        List<Movie> movies = this.movieService.findAllMovies();
//Then
        then(movies.get(0).getTitle())
                .isEqualTo(savedMovie1.getTitle());
        then(movies.get(0).getDirector())
                .isEqualTo(savedMovie1.getDirector());
        then(movies.get(0).getYearRelease())
                .isEqualTo(savedMovie1.getYearRelease());
        then(movies.get(0).getLengthMinutes())
                .isEqualTo(savedMovie1.getLengthMinutes());

        then(movies.get(1).getTitle())
                .isEqualTo(savedMovie2.getTitle());
        then(movies.get(1).getDirector())
                .isEqualTo(savedMovie2.getDirector());
        then(movies.get(1).getYearRelease())
                .isEqualTo(savedMovie2.getYearRelease());
        then(movies.get(1).getLengthMinutes())
                .isEqualTo(savedMovie2.getLengthMinutes());


    }

}

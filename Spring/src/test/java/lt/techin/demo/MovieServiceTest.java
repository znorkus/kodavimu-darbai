package lt.techin.demo;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.MovieRepository;
import lt.techin.demo.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@Transactional
public class MovieServiceTest {

    @Autowired
    private MovieRepository movieRepository;
    private MovieService movieService;

    void findAllMovies_saveMovies_returned() {
        Movie savedMovie1 = movieRepository.save(new Movie("Madagascar", "Stephen Spielberg", (short) 2005,
                (short) 60));
        Movie savedMovie2 = movieRepository.save(new Movie("Home Alone", "Stephen Spielberg", (short) 1999,
                (short) 120));

        List<Movie> movies = this.movieService.findAllMovies();

        assertThat(movies.get(0).getTitle()).isEqualTo(savedMovie1.getTitle());

    }

}

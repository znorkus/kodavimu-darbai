package lt.techin.demo.services;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Boxoffice;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.BoxofficeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.then;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
@ActiveProfiles("test")
public class BoxofficeServiceTest {

    @Autowired
    private BoxofficeService boxofficeService;
    @Autowired
    private BoxofficeRepository boxofficeRepository;
    @Autowired
    private MovieService movieService;

    @Test
        //Given
    void findAllBoxoffices_saveBoxoffices_returned() {
        Movie movie = this.movieService.saveMovie(new Movie("Test Film", "Stiven Spilberg", LocalDate.of
                (2020, 1, 1), (short) 120));
        Movie movie2 = this.movieService.saveMovie(new Movie("Test Film2", "Stiven Spilbergg", LocalDate.of
                (2021, 1, 1), (short) 110));

        Boxoffice savedBoxoffice1 = boxofficeRepository.save(new Boxoffice
                (movie, 8.5F, 5000000L, 10000000L));
        Boxoffice savedBoxoffice2 = boxofficeRepository.save(new Boxoffice
                (movie2, 9.5F, 6000000L, 20000000L));
        //When
        List<Boxoffice> boxoffices = this.boxofficeService.getAllBoxoffices();
        //Then
        then(boxoffices).containsExactly(savedBoxoffice1, savedBoxoffice2);

    }

//    @Test
//        //Given
//    void findBoxofficeById_saveBoxoffices_returned() {
//        Movie movie = this.movieService.saveMovie(new Movie
//                ("Test Film", "Stiven Spilberg", (short) 2020, (short) 120));
//
//        Boxoffice savedBoxoffice1 = boxofficeRepository.save(new Boxoffice
//                (movie, 8.5F, 5000000L, 10000000L));
//
//        //When
//        Movie movieFromDb = this.boxofficeService.findMovieById(boxoffice.getId());
//
//    }
}

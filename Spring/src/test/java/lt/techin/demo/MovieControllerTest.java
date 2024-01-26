package lt.techin.demo;

import lt.techin.demo.controllers.MovieController;
import lt.techin.demo.models.Movie;
import lt.techin.demo.services.MovieService;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = MovieController.class)
public class MovieControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private MovieService movieService;

    @Test
    void getMovies_saveMovies_returnAll() throws Exception {
        given(this.movieService.findAllMovies())
                .willReturn(List.of(new Movie
                                ("Bad Boys", "Will Smith", (short) 2008, (short) 110),
                        new Movie("300", "Steaven Spilberg", (short) 2005, (short) 120)));
        mockMvc.perform(get("/movies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title")
                        .value("Bad Boys"))
                .andExpect(jsonPath("$[0].director").value("Will Smith"))
                .andExpect(jsonPath("$[0].yearRelease").value(2008))
                .andExpect(jsonPath("$[0].lengthMinutes").value(110))
                .andExpect(jsonPath("$[1].title")
                        .value("300"))
                .andExpect(jsonPath("$[1].director").value("Steaven Spilberg"))
                .andExpect(jsonPath("$[1].yearRelease").value(2005))
                .andExpect(jsonPath("$[1].lengthMinutes").value(120));
    }
}
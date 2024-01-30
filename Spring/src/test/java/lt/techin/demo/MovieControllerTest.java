package lt.techin.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.controllers.MovieController;
import lt.techin.demo.models.Movie;
import lt.techin.demo.services.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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

        verify(this.movieService).findAllMovies();
    }

    @Test
    void insertMovie_whenSaveMovie_thenReturnIt() throws Exception {
        //given
        Movie movie = new Movie("Delivery Man", "Ken Scott", (short) 2013, (short) 105);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(movie);

        //when
        mockMvc.perform(post("/movies")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(movie)))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Delivery Man"))
                .andExpect(jsonPath("$.director").value("Ken Scott"))
                .andExpect(jsonPath("$.yearRelease").value(2013))
                .andExpect(jsonPath("$.lengthMinutes").value(105));

        verify(this.movieService).saveMovie(any(Movie.class));
    }

    @Test
    void updateMovie_whenUpdateFields_thenReturn() throws Exception {
        //given
        Movie existingMovie = new Movie("Existing Movie", "Director A", (short) 2020, (short) 120);
        Movie updateMovie = new Movie("Update Movie", "Director B", (short) 2022, (short) 150);

        given(this.movieService.existsMovieById(anyLong())).willReturn(true);
        given(this.movieService.findMovieById(anyLong())).willReturn(existingMovie);
        given(this.movieService.saveMovie(any(Movie.class))).willReturn(updateMovie);

        //when
        mockMvc.perform(put("/movies/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updateMovie))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Update Movie"))
                .andExpect(jsonPath("$.director").value("Director B"))
                .andExpect(jsonPath("$.yearRelease").value(2022))
                .andExpect(jsonPath("$.lengthMinutes").value(150));

        verify(this.movieService).existsMovieById(1L);
        verify(this.movieService).findMovieById(1L);
        verify(this.movieService).saveMovie(argThat(m -> {
            assertThat(m.getTitle()).isEqualTo("Update Movie");
            assertThat(m.getDirector()).isEqualTo("Director B");
            assertThat(m.getYearRelease()).isEqualTo((short) 2022);
            assertThat(m.getLengthMinutes()).isEqualTo((short) 150);
            return true;
        }));
    }

    @Test
    void updateMovie_whenNoMovieFound_addNewOne() throws Exception {
        //give
        Movie newMovie = new Movie("New Movie", "Director C", (short) 2023, (short) 180);

        given(this.movieService.existsMovieById(anyLong())).willReturn(false);
        given(this.movieService.saveMovie(any(Movie.class)))
                .willReturn(newMovie);

        //when
        mockMvc.perform(put("/movies/{id}", 58)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newMovie))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("New Movie"))
                .andExpect(jsonPath("$.director").value("Director C"))
                .andExpect(jsonPath("$.yearRelease").value(2023))
                .andExpect(jsonPath("$.lengthMinutes").value(180));

        verify(this.movieService).existsMovieById(58L);
        verify(this.movieService, never()).findMovieById(anyLong());
        verify(this.movieService).saveMovie(argThat(persistedMovie -> persistedMovie.getTitle().equals("New Movie")));


    }

    @Test
    void deleteMovie_whenExistingMovie() throws Exception {
        // Given
        long movieId = 1L;

        // When
        mockMvc.perform(delete("/movies/{id}", movieId))
                // Then
                .andExpect(status().isOk());

        verify(this.movieService).deleteMovieById(movieId);
    }

    @Test
    void getMovie_whenFindMovie_thenReturn() throws Exception {

        Movie movie = new Movie("Delivery Man", "Ken Scott", (short) 2013, (short) 105);
        //given
        given(this.movieService.findMovieById(anyLong()))
                .willReturn(movie);

        mockMvc.perform(get("/movies/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Delivery Man"))
                .andExpect(jsonPath("$.director").value("Ken Scott"))
                .andExpect(jsonPath("$.yearRelease").value(2013))
                .andExpect(jsonPath("$.lengthMinutes").value(105));

        verify(this.movieService).findMovieById(1L);
    }
}
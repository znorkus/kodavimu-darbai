package lt.techin.demo.controllers;

import lt.techin.demo.models.Director;
import lt.techin.demo.services.DirectorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = DirectorController.class)
public class DirectorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    DirectorService directorService;

    @Test
    void getDirectors_saveDirectors_returnAll() throws Exception {
        given(this.directorService.findAllDirectors())
                .willReturn(List.of(new Director
                                (1, "Steven Spilberg", 55),
                        new Director(2, "Tadas Vidmantas", 40)));
        mockMvc.perform(get("/directors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id")
                        .value(1))
                .andExpect(jsonPath("$[0].name")
                        .value("Stiven Spilberg"))
                .andExpect(jsonPath("$[0].age")
                        .value(55))
                .andExpect(jsonPath("$[0].id")
                        .value(2))
                .andExpect(jsonPath("$[0].name")
                        .value("Tadas Vidmantas"))
                .andExpect(jsonPath("$[0].age")
                        .value(40));

        verify(this.directorService).findAllDirectors();

    }
}

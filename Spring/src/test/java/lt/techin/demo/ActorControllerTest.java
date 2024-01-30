package lt.techin.demo;

import lt.techin.demo.controllers.ActorController;
import lt.techin.demo.models.Actor;
import lt.techin.demo.services.ActorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ActorController.class)
public class ActorControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ActorService actorService;

    @Test
    void getActors_saveActors_returnAll() throws Exception {
        given(this.actorService.getAllActors())
                .willReturn(List.of(new Actor
                                ("Stiven Spilberg", (short) 65, (short) 180, 90000L),
                        new Actor("Tadas Vidmantas", (short) 40, (short) 185, 30000L)));
        mockMvc.perform(get("/actors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name")
                        .value("Stiven Spilberg"))
                .andExpect(jsonPath("$[0].age").value(65))
                .andExpect(jsonPath("$[0].height").value(180))
                .andExpect(jsonPath("$[0].salary").value(90000))
                .andExpect(jsonPath("$[1].name")
                        .value("Tadas Vidmantas"))
                .andExpect(jsonPath("$[1].age").value(40))
                .andExpect(jsonPath("$[1].height").value(185))
                .andExpect(jsonPath("$[1].salary").value(30000));

        verify(this.actorService).getAllActors();
    }
}

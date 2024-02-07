package lt.techin.demo.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import lt.techin.demo.models.Actor;
import lt.techin.demo.services.ActorService;
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

    @Test
    void insertActor_whenSaveActor_thenReturnIt() throws Exception {
        //given
        Actor actor = new Actor("Tom Hanks", (short) 65, (short) 180, 100000L);
        given(this.actorService.saveActor(any(Actor.class))).willReturn(actor);

        //when
        mockMvc.perform(post("/actors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(actor)))

                //then
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Tom Hanks"))
                .andExpect(jsonPath("$.age").value(65))
                .andExpect(jsonPath("$.height").value(180))
                .andExpect(jsonPath("$.salary").value(100000));

        verify(this.actorService).saveActor(any(Actor.class));
    }

    @Test
    void updateActor_whenUpdateFields_thenReturn() throws Exception {
        //given
        Actor existingActor = new Actor("Existing Actor", (short) 60, (short) 180, 50000L);
        Actor updateActor = new Actor("Update Actor", (short) 55, (short) 200, 55000L);

        given(this.actorService.existsActorById(anyLong())).willReturn(true);
        given(this.actorService.findActorById(anyLong())).willReturn(existingActor);
        given(this.actorService.saveActor(any(Actor.class))).willReturn(updateActor);

        //when
        mockMvc.perform(put("/actors/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updateActor))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Update Actor"))
                .andExpect(jsonPath("$.age").value(55))
                .andExpect(jsonPath("$.height").value(200))
                .andExpect(jsonPath("$.salary").value(55000));

        verify(this.actorService).existsActorById(1L);
        verify(this.actorService).findActorById(1L);
        verify(this.actorService).saveActor(argThat(a -> {
            assertThat(a.getName()).isEqualTo("Update Actor");
            assertThat(a.getAge()).isEqualTo(55);
            assertThat(a.getHeight()).isEqualTo(200);
            assertThat(a.getSalary()).isEqualTo(55000);
            return true;
        }));
    }

    @Test
    void updateActor_whenNoActorFound_addNewOne() throws Exception {
        //give
        Actor newActor = new Actor("New Actor", (short) 77, (short) 215, 85000L);

        given(this.actorService.existsActorById(anyLong())).willReturn(false);
        given(this.actorService.saveActor(any(Actor.class)))
                .willReturn(newActor);

        //when
        mockMvc.perform(put("/actors/{id}", 33)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(newActor))
                        .accept(MediaType.APPLICATION_JSON))

                //then
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("New Actor"))
                .andExpect(jsonPath("$.age").value(77))
                .andExpect(jsonPath("$.height").value(215))
                .andExpect(jsonPath("$.salary").value(85000));

        verify(this.actorService).existsActorById(33L);
        verify(this.actorService, never()).findActorById(anyLong());
        verify(this.actorService).saveActor(argThat(persistedActor -> persistedActor.getName().equals("New Actor")));

    }

    @Test
    void deleteActor_whenExistingActor() throws Exception {
        // Given
        long actorId = 1L;

        // When
        mockMvc.perform(delete("/actors/{id}", actorId))
                // Then
                .andExpect(status().isOk());

        verify(this.actorService).deleteActorById(actorId);
    }

    @Test
    void getActor_whenFindActor_thenReturn() throws Exception {

        Actor actor = new Actor("Tom Hanks", (short) 65, (short) 180, 100000L);
        //given
        given(this.actorService.findActorById(anyLong()))
                .willReturn(actor);

        mockMvc.perform(get("/actors/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Tom Hanks"))
                .andExpect(jsonPath("$.age").value(65))
                .andExpect(jsonPath("$.height").value(180))
                .andExpect(jsonPath("$.salary").value(100000));

        verify(this.actorService).findActorById(1L);
    }
}

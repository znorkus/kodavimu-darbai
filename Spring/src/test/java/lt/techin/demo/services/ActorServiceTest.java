package lt.techin.demo.services;

import jakarta.transaction.Transactional;
import lt.techin.demo.models.Actor;
import lt.techin.demo.repositories.ActorRepository;
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
public class ActorServiceTest {

    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorRepository actorRepository;

    @Test
        //Given
    void findAllActors_saveActors_returned() {
        Actor savedActor1 = actorRepository.save(new Actor("Tom Hanks", (short) 55, (short) 185, 80000L));
        Actor savedActor2 = actorRepository.save(new Actor("Tim Allen", (short) 65, (short) 170, 90000L));
        //When
        List<Actor> actors = this.actorService.getAllActors();
//Then
        then(actors).containsExactly(savedActor1, savedActor2);

    }

    @Test
    void findActorById_saveActors_returned() {
        Actor savedActor1 = actorRepository.save(new Actor("Woody Allen", (short) 65, (short) 200,
                90000L));
        Actor savedActor2 = actorRepository.save(new Actor("John Cena", (short) 50, (short) 199,
                85000L));
        //When
        Actor actorFromDb = this.actorService.findActorById(savedActor1.getId());
//Then
        then(actorFromDb).isEqualTo(savedActor1);

    }

    @Test
    void findActorById_findNotExistent_throwError() {
        Throwable throwable = catchThrowable(
                () -> this.actorService.findActorById(1));

        then(throwable).isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void saveActor_saveIt_thenReturn() {
        Actor savedActor = this.actorService
                .saveActor(new Actor("Tom Hanks", (short) 55,
                        (short) 185, 80000L));

        Actor foundActor = this.actorRepository
                .findById(savedActor.getId()).orElse(null);
    }

    @Test
    void existsActorById_checkIfExists_returnTrue() {
        Actor savedActor = this.actorRepository.save(new Actor("Tim Allen",
                (short) 65, (short) 169, 100000L));

        boolean existsActor = this.actorService
                .existsActorById(savedActor.getId());

        then(existsActor).isTrue();
    }

    @Test
    void deleteActorById_delete_cannotFind() {
        Actor savedActor = this.actorRepository.save(new Actor("Broken Flowers",
                (short) 70, (short) 175, 95000L));
        this.actorService.deleteActorById(savedActor.getId());

        then(this.actorRepository.existsById(savedActor.getId())).isFalse();
    }

}

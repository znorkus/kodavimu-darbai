package lt.techin.demo.services;

import lt.techin.demo.models.Actor;
import lt.techin.demo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {

    private final ActorRepository actorRepository;
    private final ActorService actorService;

    @Autowired
    public ActorService(ActorRepository actorRepository, ActorService actorService) {

        this.actorRepository = actorRepository;
        this.actorService = actorService;
    }

    public List<Actor> getAllActors() {
        return
                this.actorRepository.findAll();
    }

    public Actor findActorById(long id) {
        return
                this.actorRepository.findById(id).orElseThrow();
    }

    public Actor saveActor(Actor actor) {
        return this.actorRepository.save(actor);
    }

    public boolean existsActorById(long id) {
        return this.actorRepository.existsById(id);

    }

    public void deleteMovieById(long id) {
        this.actorRepository.deleteById(id);
    }
}

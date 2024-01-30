package lt.techin.demo.controllers;


import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.ActorRepository;
import lt.techin.demo.services.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    private final ActorService actorService;


    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @GetMapping("/actors")
    public List<Actor> getActors() {
        return this.actorService.getAllActors();
    }


    @GetMapping("/actors/{id}")
    public Actor getActor(@PathVariable long id) {
        return this.actorService.findActorById(id);
    }

    @PostMapping("/actors")
    public void insertActor(@RequestBody Actor actor) {
        this.actorService.saveActor(actor);
    }

    @PutMapping("/actors/{id}")
    public Actor updateActor(@RequestBody Actor actor, @PathVariable long id) {
        if (this.actorService.existsActorById(id)) {
            Actor actorFromDb = this.actorService.findActorById(id);

            actorFromDb.setName(actor.getName());
            actorFromDb.setAge(actor.getAge());
            actorFromDb.setHeight(actor.getHeight());
            actorFromDb.setSalary(actor.getSalary());

            return this.actorService.saveActor(actorFromDb);
        }

        return this.actorService.saveActor(actor);
    }

    @DeleteMapping("/actors/{id}")
    public void deleteActor(@PathVariable long id) {
        this.actorService.deleteActorById(id);
    }
}
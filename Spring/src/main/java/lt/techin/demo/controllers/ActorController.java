package lt.techin.demo.controllers;


import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Movie;
import lt.techin.demo.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ActorController {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorController(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }


    @GetMapping("/actors/{id}")
    public Actor getActor(@PathVariable long id) {
        return this.actorRepository.findById(id).orElseThrow();
    }

    @PostMapping("/actors")
    public void insertActor(@RequestBody Actor actor) {
        this.actorRepository.save(actor);
    }

    //    @GetMapping("/actors")
//    public List<Actor> getActors() {
//
//        return this.actorRepository.findAll();
//    }
//
//    @GetMapping("/actors/{index}")
//    public Actor getActors(@PathVariable int index) {
//
//        return null;
//    }
}
package lt.techin.demo.controllers;


import lt.techin.demo.models.Actor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ActorController {

    private ArrayList<Actor> actors = new ArrayList<>(
            List.of(new Actor(1L, "Tim Allen", (short) 55,
                            (short) 180, 100000L),
                    new Actor(2L, "Tom Hanks", (short) 57,
                            (short) 182, 120000L)));


    @GetMapping("/actors")
    public ArrayList<Actor> getMovies() {
        return this.actors;
    }

    @GetMapping("/actors/{index}")
    public Actor getMovie(@PathVariable int index) {

        return this.actors.get(index);
    }
}
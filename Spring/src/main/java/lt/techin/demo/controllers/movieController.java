package lt.techin.demo.controllers;


import lt.techin.demo.models.Movie;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class movieController {

    private ArrayList<Movie> movies = new ArrayList<>(
            List.of(new Movie(1L, "Toy Story", "John Lasseter", (short) 1995, (short) 81),
                    new Movie(2L, "A Bug's Life", "John Lasseter", (short) 1998, (short) 81)));


    @GetMapping("/movies")
    public ArrayList<String> getMovies() {
        return movies;
    }

    @GetMapping("/movies/{index}")
    public String getMovie(@PathVariable int index) {
        return this.movies.get(index);
    }
}

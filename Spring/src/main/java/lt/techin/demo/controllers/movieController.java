package lt.techin.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class movieController {


    @GetMapping("/movies")
    public String getMovie() {
        return"Toy Story 1";
    }
}

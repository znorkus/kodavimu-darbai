package lt.techin.demo.controllers;

import lt.techin.demo.models.Director;
import lt.techin.demo.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
public class DirectorController {

    private final DirectorService directorService;


    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @GetMapping("/directors")
    public List<Director> getDirectors() {
        return this.directorService.findAllDirectors();
    }


    @GetMapping("/directors/{id}")
    public Director getDirector(@PathVariable long id) {
        return this.directorService.findDirectorById(id);
    }

    @PostMapping("/directors")
    public ResponseEntity<Director> insertDirector(@RequestBody Director director) {
        Director savedDirector = this.directorService.saveDirector(director);

        return ResponseEntity
                .created(ServletUriComponentsBuilder.fromCurrentRequest()
                        .path("/{id}").buildAndExpand(savedDirector.getId())
                        .toUri())
                .body(savedDirector);
    }
//    public Director insertDirector(@RequestBody Director director) {
//        return this.directorService.saveDirector(director);
//    }

    @PutMapping("/directors/{id}")
    public Director updateDirector(@RequestBody Director director, @PathVariable long id) {
        if (this.directorService.existsDirectorById(id)) {
            Director directorFromDb = this.directorService.findDirectorById(id);

            directorFromDb.setName(director.getName());
            directorFromDb.setAge(director.getAge());

            return this.directorService.saveDirector(directorFromDb);
        }

        return this.directorService.saveDirector(director);
    }

    @DeleteMapping("/directors/{id}")
    public void deleteDirector(@PathVariable long id) {
        this.directorService.deleteDirectorById(id);
    }
}

package lt.techin.demo.controllers;


import lt.techin.demo.models.Boxoffice;
import lt.techin.demo.repositories.BoxofficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BoxofficeController {

    private final BoxofficeRepository boxofficeRepository;

    @Autowired
    public BoxofficeController(BoxofficeRepository boxofficeRepository) {
        this.boxofficeRepository = boxofficeRepository;
    }

    @GetMapping("/boxoffices")
    public List<Boxoffice> getBoxoffice() {
        return this.boxofficeRepository.findAll();
    }

    @GetMapping("/boxoffices/{id}")
    public Boxoffice getBoxoffice(@PathVariable long id) {
        return this.boxofficeRepository.findById(id).orElseThrow();
    }

}

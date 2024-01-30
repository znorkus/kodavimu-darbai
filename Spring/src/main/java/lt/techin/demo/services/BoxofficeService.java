package lt.techin.demo.services;

import lt.techin.demo.models.Actor;
import lt.techin.demo.models.Boxoffice;
import lt.techin.demo.repositories.BoxofficeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoxofficeService {

    private final BoxofficeRepository boxofficeRepository;

    @Autowired

    public BoxofficeService(BoxofficeRepository boxofficeRepository) {

        this.boxofficeRepository = boxofficeRepository;
    }

    public List<Boxoffice> getAllBoxoffices() {
        return this.boxofficeRepository.findAll();
    }

    public Boxoffice findMovieById(long id) {
        return this.boxofficeRepository.findById(id).orElseThrow();
    }

    public Boxoffice saveBoxoffice(Boxoffice boxoffice) {
        return this.boxofficeRepository.save(boxoffice);
    }

    public boolean existsBoxofficeById(long id) {
        return this.boxofficeRepository.existsById(id);

    }

    public void deleteBoxofficeById(long id) {
        this.boxofficeRepository.deleteById(id);
    }

}
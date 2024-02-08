package lt.techin.demo.services;

import lt.techin.demo.models.DirectorMovie;
import lt.techin.demo.models.DirectorMovieId;
import lt.techin.demo.repositories.DirectorMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectorMovieService {

    private final DirectorMovieRepository directorMovieRepository;

    @Autowired
    public DirectorMovieService(DirectorMovieRepository directorMovieRepository) {
        this.directorMovieRepository = directorMovieRepository;
    }

    public DirectorMovie saveDirectorMovie(DirectorMovie directorMovie) {
        return directorMovieRepository.save(directorMovie);
    }

    public void deleteDirectorMovieById(DirectorMovieId id) {
        directorMovieRepository.deleteById(id);
    }

    public boolean existsDirectorMovieById(DirectorMovieId id) {
        return directorMovieRepository.existsById(id);
    }
}
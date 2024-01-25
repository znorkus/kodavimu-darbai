package lt.techin.demo.repositories;

import lt.techin.demo.models.Boxoffice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoxofficeRepository extends JpaRepository<Boxoffice, Long> {
}
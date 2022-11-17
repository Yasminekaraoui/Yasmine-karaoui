package tn.esprit.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Spring.Entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement,Integer> {
}

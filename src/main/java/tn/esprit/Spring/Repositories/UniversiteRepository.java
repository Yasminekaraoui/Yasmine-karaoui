package tn.esprit.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Spring.Entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite,Integer> {
}

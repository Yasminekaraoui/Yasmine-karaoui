package tn.esprit.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Spring.Entities.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe,Integer> {
}

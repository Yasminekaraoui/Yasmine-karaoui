package tn.esprit.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Spring.Entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat,Integer> {

     int countByArchiveFalseAndEtudiantNomEAndEtudiantPrenomE(String NomE, String PrenomE);
}

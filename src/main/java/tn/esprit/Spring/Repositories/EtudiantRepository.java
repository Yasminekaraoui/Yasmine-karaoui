package tn.esprit.Spring.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.Spring.Entities.Etudiant;

import java.util.List;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {
    public Etudiant findByNomEAndPrenomE(String nomE,String prenomE);
@Query("select e From Etudiant e WHERE e.nomE=?1 and e.prenomE=?2")//jbql
//@Query(value = "select * From etudiant WHERE e.nomE=?1 and e.prenomE=?2",nativeQuery = true)  methode 1
//Etudiant findByNomEAndPrenomE ( String nom,String prenom);

    Etudiant retrieveEtudiantByNomPrenom(String nom, String prenom);

    List<Etudiant> findByDepartementIdDepartement(int idDepartement);




}

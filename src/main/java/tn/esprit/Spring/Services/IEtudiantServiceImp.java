package tn.esprit.Spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Spring.Entities.Contrat;
import tn.esprit.Spring.Entities.Departement;
import tn.esprit.Spring.Entities.Equipe;
import tn.esprit.Spring.Entities.Etudiant;
import tn.esprit.Spring.Repositories.DepartementRepository;
import tn.esprit.Spring.Repositories.EquipeRepository;
import tn.esprit.Spring.Repositories.EtudiantRepository;
import tn.esprit.Spring.Repositories.ContratRepository;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Service        //creer une instance (bean) de cette classe
public class IEtudiantServiceImp implements IEtudiantService {

    @Autowired
    EtudiantRepository etudiantRepository;
    @Autowired
    EquipeRepository equipeRepository;
    @Autowired
    ContratRepository contratrepository;
    @Autowired
    DepartementRepository departementRepository;

    @Override
    public Etudiant addStudent(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateStudent(Etudiant e) {

        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getById(Integer IdEtudiant) {

        return etudiantRepository.findById(IdEtudiant).orElse(null);
    }

    @Override
    public List<Etudiant> getAllStudent() {

        return etudiantRepository.findAll();
    }

    @Override
    public void removeStudent(Integer idEtudiant) {

        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public void addAndAssignEtudiant(int idEtudiant, int idDepartement) {
        Etudiant e = etudiantRepository.findById(idEtudiant).orElse(null);
        Departement d = departementRepository.findById(idDepartement).orElse(null);
        if (d != null && e != null) {
            e.setDepartement(d);
        }
        etudiantRepository.save(e);
    }

    @Transactional
    @Override
    public Etudiant AssignEtudiantToEquipeAndContrat(Etudiant e, Integer idContrat, Integer idEquipe) {
        Contrat contrat = contratrepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        if (contrat != null && equipe != null) {
            Etudiant etudiant = etudiantRepository.save(e);

            //Managed Entity
            contrat.setEtudiant(etudiant);
           // contratrepository.save(contrat);

            //Managed Entity
            equipe.getEtudiants().add(etudiant);
           // equipeRepository.save(equipe);


            //if the work is based on ManyToMany
          /* if(etudiant.getEquipes()!= null) {
               etudiant.getEquipes().add(equipe);
           } else{
               List<Equipe> equipe1 = new ArrayList<Equipe>();
               equipe1.add(equipe);
               etudiant.setEquipes(equipe1);
           }*/

            return etudiant;
        }
        return null;
    }



    @Override
    public List<Etudiant> getEtudiantsByDepartement(int idDepartement) {

        return etudiantRepository.findByDepartementIdDepartement(idDepartement);
//hedhi wla hedhi, bel key word wla blech
       /* Departement departement = departementRepository.findById(idDepartement).orElse(null);
        if(departement!=null)
        {
        return departement.getEtudiants();
        }*/

    }

    }


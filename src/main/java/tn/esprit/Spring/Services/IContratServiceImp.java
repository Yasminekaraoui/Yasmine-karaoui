package tn.esprit.Spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Spring.Entities.Contrat;
import tn.esprit.Spring.Entities.Etudiant;
import tn.esprit.Spring.Repositories.ContratRepository;
import tn.esprit.Spring.Repositories.EtudiantRepository;

import java.util.Date;
import java.util.List;

@Service
public class IContratServiceImp implements IContratService{

    @Autowired
    ContratRepository contratRepository;
    @Autowired
    EtudiantRepository etudiantRepository;


    @Override
    public Contrat addContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat updateContrat(Contrat c) {
        return contratRepository.save(c);
    }

    @Override
    public Contrat getById(Integer IdContrat) {
        return contratRepository.findById(IdContrat).orElse(null);
    }

    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public void removeContrat(Integer IdContrat) {
        contratRepository.deleteById(IdContrat);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
       Etudiant etudiant=etudiantRepository.findByNomEAndPrenomE(nomE, prenomE);
        Contrat contrat=contratRepository.findById(ce.getIdContrat()).orElse(null);

     int ceEtud=0 ;
     List<Contrat> contrats=etudiant.getContrats();
     for(Contrat c:contrats) {
         if (!c.getArchive()) {
             ceEtud++;
         }
     }
     if(etudiant!=null &&ceEtud<=5){
         ce.setEtudiant(etudiant);
     }
     return contratRepository.save(ce);

        List <Etudiant> etudiants = etudiantRepository.findAll();
        Etudiant etudiant=null;
        for (Etudiant etudiant1:etudiants)
            if(etudiant1.getNomE().equals(nomE)&&etudiant1.getPrenomE().equals(prenomE)){
                etudiant=etudiant1;
            }
        int nbrContratActifs=0;
        if(etudiant!=null){
            for (Contrat c : etudiant.getContrats()){
                if (c.getArchive().equals(false)) {
                    nbrContratActifs++;
                }
            }
            if(nbrContratActifs<5){
                ce.setEtudiant(etudiant);
            }
        } return contratRepository.save(ce);
    }

    @Override
    public Integer nbContratsValides(Date startDate, Date endDate) {
        List<Contrat> contrats=contratRepository.findAll();
        int i=0;
        for (Contrat ct:contrats) {
            if (ct.getDateDebutContrat().toString().equals(startDate.toString())
                    &&
                    ct.getDateFinContrat().toString().equals(endDate.toString()))
            {
                i++;
            }
        }
        return i;
    }


}

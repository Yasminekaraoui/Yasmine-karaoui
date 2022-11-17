package tn.esprit.Spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Spring.Entities.Departement;
import tn.esprit.Spring.Entities.Universite;
import tn.esprit.Spring.Repositories.DepartementRepository;
import tn.esprit.Spring.Repositories.UniversiteRepository;

import java.util.List;

@Service        //cree moin une instance (bean) de cette classe
public class IDepartementServiceImp implements IDepartementService{

    @Autowired
    DepartementRepository departementRepository;
    @Autowired
    UniversiteRepository universiteRepository;
    @Override
    public Departement addDepartement(Departement d) {

        return departementRepository.save(d);
    }

    @Override
    public Departement updateDepartement(Departement d) {

        return departementRepository.save(d);
    }

    @Override
    public Departement getById(Integer IdDepartement) {

        return departementRepository.findById(IdDepartement).orElse(null);
    }

    @Override
    public List<Departement> getAllDepartement() {

        return departementRepository.findAll();
    }

    @Override
    public void removeDepartement(Integer IdDepartement) {

        departementRepository.deleteById(IdDepartement);
    }

    @Override
    public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
        Universite universite= universiteRepository.findById(idUniversite).orElse(null);
        Departement departement= departementRepository.findById(idDepartement).orElse(null);
        if(universite !=null && departement!=null){
            universite.getDepartemment().add(departement);
            universiteRepository.save(universite);
        }

    }

    @Override
    public List<Departement> retrieveDepartementsByUniversite(Integer idUniversite) {
        Universite universite=universiteRepository.findById(idUniversite).orElse(null);
        if(universite!=null){
            return  universite.getDepartemment();
        }
        return null;

    }

}

package tn.esprit.Spring.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Spring.Entities.Universite;
import tn.esprit.Spring.Repositories.UniversiteRepository;

import java.util.List;

@Service        //cree moin une instance (bean) de cette classe
public class IUniversiteServiceImp implements IUnivresiteService{

    @Autowired
    UniversiteRepository universiteRepository;


    @Override
    public Universite addUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite updateUniversite(Universite u) {
        return universiteRepository.save(u);
    }

    @Override
    public Universite getById(Integer IdUniversite) {
        return universiteRepository.findById(IdUniversite).orElse(null);
    }

    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public void removeUniversite(Integer IdUniversite) {
        universiteRepository.deleteById(IdUniversite);
    }
}

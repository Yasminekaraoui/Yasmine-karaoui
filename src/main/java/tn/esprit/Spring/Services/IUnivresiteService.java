package tn.esprit.Spring.Services;

import tn.esprit.Spring.Entities.Universite;

import java.util.List;

public interface IUnivresiteService {
    public Universite addUniversite(Universite c);
    public Universite updateUniversite(Universite c);
    public Universite getById(Integer IdUniversite);
    public List<Universite> getAllUniversite();
    public void removeUniversite(Integer IdUniversite);
}

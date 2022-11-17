package tn.esprit.Spring.Entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    private Niveau niveau;

    @ManyToMany
    private List<Etudiant> etudiants;

    @OneToOne(mappedBy = "equipe")
    private DetailEquipe detailEquipe;
}
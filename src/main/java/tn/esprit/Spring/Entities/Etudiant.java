package tn.esprit.Spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEtudiant;
    private String prenomE;
    private String nomE;
    @Enumerated(EnumType.STRING)
    private Option option;
    @Transient
    private String confirmpwd;

    @ManyToOne//maapedBy dima fil a9al cardinalité exp:Etudiant 1---->* Contrat
   @JsonIgnore
    private Departement departement;

    @ManyToMany(mappedBy = "etudiants") //fil ManyToMany may9ala9ch nhotou mappedBy kima nhebou
    private List<Equipe> equipes;

    @OneToMany (mappedBy = "etudiant")
    private List<Contrat> contrats;
}

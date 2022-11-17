package tn.esprit.Spring.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idContrat;
    @Temporal(value = TemporalType.DATE)
    private Date dateDebutContrat;
    @Temporal(value = TemporalType.DATE)
    private Date dateFinContrat;
    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private Boolean archive;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonIgnore
    private Etudiant etudiant;
}

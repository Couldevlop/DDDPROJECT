package com.openlab.edition.domaine.auteur.model;



import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.auteur.Skills;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Auteur {
    private Long idAuteur;
    @ElementCollection
    private List<Skills> skills;
    private String name;
    private String email;



    public Auteur register(AuteurProvider auteurProvider){
        return auteurProvider.save(this);
    }

    public static Optional<Auteur> findById(AuteurProvider auteurProvider, Long id){
        return auteurProvider.findById(id);
    }


}

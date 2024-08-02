package com.openlab.edition.domaine.cours.model;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.auteur.model.Auteur;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cours extends Contenu {
    private String niveau;
    private String subject;
    private String description;

    public boolean verifySkillsAuteur(){
        Auteur auteur = this.getAuteur();
        return   auteur.getSkills().contains(this.subject);
    }
}

package com.openlab.edition.infras.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class CoursEntity extends ContenuEntity {
    private String subject;

    public boolean verifySkillsAuteur(){
        Auteur auteur = this.getAuteur();
        return   auteur.getSkills().contains(this.subject);
    }
}

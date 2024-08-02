package com.openlab.edition.infras.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Table(name = "cours")
public class CoursEntity extends ContenuEntity {
    private String subject;
    private String description;
    public boolean verifySkillsAuteur(){
        AuteurEntity auteur = this.getAuteurId();
        return   auteur.getSkills().contains(this.subject);
    }
}

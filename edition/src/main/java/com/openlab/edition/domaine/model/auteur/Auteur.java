package com.openlab.edition.domaine.model.auteur;

import com.openlab.edition.domaine.model.Skills;

import java.util.List;

public class Auteur {
    private Long idAuteur;
    private List<Skills> skills;
    private String name;
    private String email;


    public Long getIdAuteur() {
        return idAuteur;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}

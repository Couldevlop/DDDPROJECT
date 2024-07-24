package com.openlab.edition.domaine.editeur.model;

import com.openlab.edition.domaine.auteur.Skills;
import com.openlab.edition.domaine.editeur.EditeurProvider;

import java.util.List;

public class Editeur {
    private Long idEditeur;
    private String email;
    private List<Skills> skills;
    private EditeurProvider editeurProvider;


    //construction du builder
    private Editeur(EditeurBuilder build) {
        this.idEditeur = build.idEditeur;
        this.email = build.email;
        this.skills = build.skills;
        this.editeurProvider = build.editeurProvider;
    }


    public static class EditeurBuilder{
        private Long idEditeur;
        private String email;
        private List<Skills> skills;
        private EditeurProvider editeurProvider;


        public EditeurBuilder idEditeur(long idEditeur){
            this.idEditeur = idEditeur;
            return this;
        }


        public EditeurBuilder email(String email){
            this.email = email;
            return this;
        }

        public EditeurBuilder skills(List<Skills> skills){
            this.skills = skills;
            return this;
        }

        public EditeurBuilder editeurProvider(EditeurProvider editeurProvider){
            this.editeurProvider = editeurProvider;
        return this;
        }

        // construction de l'objet
        public Editeur build(){
            return new Editeur(this);
        }
    }

    public Long getIdEditeur() {
        return idEditeur;
    }

    public String getEmail() {
        return email;
    }

    public List<Skills> getSkills() {
        return skills;
    }

    public EditeurProvider getEditeurProvider() {
        return editeurProvider;
    }
}

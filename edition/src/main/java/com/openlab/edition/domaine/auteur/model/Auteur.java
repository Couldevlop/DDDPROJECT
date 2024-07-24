package com.openlab.edition.domaine.auteur.model;



import com.openlab.edition.domaine.auteur.AuteurProvider;
import com.openlab.edition.domaine.auteur.Skills;

import java.util.List;


public class Auteur {
    private Long idAuteur;
    private List<Skills> skills;
    private String name;
    private String email;
    private AuteurProvider auteurProvider;


    private Auteur(AuteurBuilder build) {
        this.idAuteur = build.idAuteur;
        this.skills = build.skills;
        this.name = build.name;
        this.email = build.email;
        this.auteurProvider = build.auteurProvider;
    }


    public static class AuteurBuilder{
        private Long idAuteur;
        private List<Skills> skills;
        private String name;
        private String email;
        private AuteurProvider auteurProvider;

       // Methodes pour construire le builder
        public AuteurBuilder idAuteur(long idAuteur){
            this.idAuteur = idAuteur;
            return this;
        }

        public AuteurBuilder name(String name){
            this.name = name;
            return this;
        }

        public AuteurBuilder skills(List<Skills> skills){
            this.skills = skills;
            return this;
        }

        public AuteurBuilder email(String email){
            this.email = email;
            return this;
        }

        public AuteurBuilder auteurProvider(AuteurProvider auteurProvider){
            this.auteurProvider = auteurProvider;
            return this;
        }

        // construction de l'objet
        public Auteur build(){
            return new Auteur(this);
        }
    }


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

    public AuteurProvider getAuteurProvider() {
        return auteurProvider;
    }
}

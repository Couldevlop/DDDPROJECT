package com.openlab.edition.domaine.cours.model;

import com.openlab.edition.domaine.cours.CoursProvider;

public class Cours {
    private long idCours;
    private String title;
    private String content;
    private String domaine;
    private CoursProvider coursProvider;


    private Cours(CoursBuilder build) {
        this.idCours = build.idCours;
        this.title = build.title;
        this.content = build.content;
        this.domaine = build.domaine;
        this.coursProvider = build.coursProvider;
    }


    public static class CoursBuilder{
        private long idCours;
        private String title;
        private String content;
        private String domaine;
        private CoursProvider coursProvider;


        // les méthodes pour la construction du builder
        public CoursBuilder idCours(long idCours){
           this.idCours = idCours;
           return this;
        }

        public CoursBuilder tittitlere(String title){
            this.title = title;
            return this;
        }

        public CoursBuilder content(String content){
            this.content = content;
            return this;
        }

        public CoursBuilder domaine(String domaine){
            this.content = content;
            return this;
        }

        //constuction de l'objet cours
        public Cours build(){
            return new Cours(this);
        }

    }

    public long getIdCours() {
        return idCours;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getDomaine() {
        return domaine;
    }

    public CoursProvider getCoursProvider() {
        return coursProvider;
    }
}

package com.openlab.comptabilite.domaine.cours.model;

import com.openlab.comptabilite.domaine.cours.CoursProvider;

public class Cours {
    private long idCours;
    private String ref;
    private double nbrVues;
    private CoursProvider coursProvider;


    private Cours(CoursBuilder build) {
        this.idCours = build.idCours;
        this.ref = build.ref;
        this.nbrVues = build.nbrVues;
        this.coursProvider = build.coursProvider;

    }

    public static class CoursBuilder{
        private long idCours;
        private String ref;
        private double nbrVues;
        private CoursProvider coursProvider;


        public CoursBuilder idCours(long idCours){
            this.idCours = idCours;
            return this;
        }

        public CoursBuilder ref(String ref){
            this.ref = ref;
            return this;
        }

        public CoursBuilder nbrVues(double nbrVues){
            this.nbrVues = nbrVues;
            return this;
        }

        public CoursBuilder coursProvider(CoursProvider coursProvider){
            this.coursProvider = coursProvider;
            return this;
        }

        public Cours build(){
            return new Cours(this);
        }
    }

    public long getIdCours() {
        return idCours;
    }

    public String getRef() {
        return ref;
    }

    public double getNbrVues() {
        return nbrVues;
    }

    public CoursProvider getCoursProvider() {
        return coursProvider;
    }
}

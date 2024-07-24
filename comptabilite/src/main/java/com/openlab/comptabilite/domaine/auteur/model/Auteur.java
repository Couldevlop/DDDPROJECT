package com.openlab.comptabilite.domaine.auteur.model;

public class Auteur {
    private long idAuteur;
    private Rib rib;


    private Auteur(AuteurBuilder build) {
        this.idAuteur = build.idAuteur;
        this.rib = build.rib;
    }

    private static class AuteurBuilder{
        private long idAuteur;
        private Rib rib;


        public AuteurBuilder idAuteur(long idAuteur){
            this.idAuteur = idAuteur;
            return this;
        }


        public AuteurBuilder rib(Rib rib){
            this.rib = rib;
            return this;
        }

        public Auteur build(){
            return new Auteur(this);
        }
    }

    public long getIdAuteur() {
        return idAuteur;
    }

    public Rib getRib() {
        return rib;
    }
}

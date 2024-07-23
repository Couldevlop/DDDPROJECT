package com.openlab.comptabilite.domaine.model;

public class Rib {
    private final Long idRib;
    private final String banque;
    private final String guichet;
    private final String compte;
    private final String cleRib;

    public Rib(Long idRib, String banque, String guichet, String compte, String cleRib) {
        this.idRib = idRib;
        this.banque = banque;
        this.guichet = guichet;
        this.compte = compte;
        this.cleRib = cleRib;
    }


    public Long getIdRib() {
        return idRib;
    }

    public String getBanque() {
        return banque;
    }

    public String getGuichet() {
        return guichet;
    }

    public String getCompte() {
        return compte;
    }

    public String getCleRib() {
        return cleRib;
    }
}

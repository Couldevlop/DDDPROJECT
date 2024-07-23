package com.openlab.comptabilite.domaine.model;

public class Montant {
    private final Long idMontant;
    private final double value;
    private final String currency;

    public Montant(Long idMontant, double value, String currency) {
        this.idMontant = idMontant;
        this.value = value;
        this.currency = currency;
    }

    public Long getIdMontant() {
        return idMontant;
    }

    public double getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }
}

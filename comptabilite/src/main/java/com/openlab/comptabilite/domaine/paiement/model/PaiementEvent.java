package com.openlab.comptabilite.domaine.paiement.model;

import java.time.LocalDate;

public class PaiementEvent {
    private final long idPaiement;
    private final double montant;
    private final double nbrVues;
    private final String titre;
    private final LocalDate date;

    public PaiementEvent(long idPaiement, double montant, double nbrVues, String titre, LocalDate date) {
        this.idPaiement = idPaiement;
        this.montant = montant;
        this.nbrVues = nbrVues;
        this.titre = titre;
        this.date = date;
    }

    public long getIdPaiement() {
        return idPaiement;
    }

    public double getMontant() {
        return montant;
    }

    public double getNbrVues() {
        return nbrVues;
    }

    public String getTitre() {
        return titre;
    }

    public LocalDate getDate() {
        return date;
    }
}

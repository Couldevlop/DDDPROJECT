package com.openlab.comptabilite.domaine.paiement.model;

import com.openlab.comptabilite.domaine.paiement.PaiementProvider;
import com.openlab.comptabilite.domaine.paiement.Status;

import java.time.LocalDate;

public class Paiement {
    private long idPaiement;
    private LocalDate date;
    private Montant montant;
    private Status status;
    private PaiementProvider paiementProvider;


    private Paiement(PaiementBuilder build) {
        this.idPaiement = build.idPaiement;
        this.date = build.date;
        this.montant = build.montant;
        this.status = build.status;
        this.paiementProvider = build.paiementProvider;


    }

    public static class PaiementBuilder{
        private long idPaiement;
        private LocalDate date;
        private Montant montant;
        private Status status;
        private PaiementProvider paiementProvider;


        public PaiementBuilder idPaiement(long idPaiement){
            this.idPaiement = idPaiement;
            return this;
        }

        public PaiementBuilder date(LocalDate date){
            this.date = date;
            return this;
        }

        public PaiementBuilder montant(Montant montant){
            this.montant = montant;
            return this;
        }

        public PaiementBuilder status(Status status){
            this.status = status;
            return this;
        }


        public PaiementBuilder paiementProvider(PaiementBuilder paiementBuilder){
            this.paiementProvider = paiementProvider;
            return this;
        }

        public Paiement build(){
            return  new Paiement(this);
        }
    }

    public long getIdPaiement() {
        return idPaiement;
    }

    public LocalDate getDate() {
        return date;
    }

    public Montant getMontant() {
        return montant;
    }

    public Status getStatus() {
        return status;
    }

    public PaiementProvider getPaiementProvider() {
        return paiementProvider;
    }
}

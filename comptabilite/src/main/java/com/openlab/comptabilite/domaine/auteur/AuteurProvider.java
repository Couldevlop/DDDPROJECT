package com.openlab.comptabilite.domaine.auteur;

import com.openlab.comptabilite.domaine.auteur.model.Auteur;

public interface AuteurProvider {
    Auteur registerAuteur(Auteur auteur);
}

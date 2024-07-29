package com.openlab.edition.domaine.auteur;

import com.openlab.edition.domaine.auteur.model.Auteur;

import java.util.Optional;

public interface AuteurProvider {
   Auteur save(Auteur auteur);
   Optional<Auteur> findById(long id);
}

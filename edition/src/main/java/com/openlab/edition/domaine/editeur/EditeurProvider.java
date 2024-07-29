package com.openlab.edition.domaine.editeur;

import com.openlab.edition.domaine.editeur.model.Editeur;

import java.util.Optional;

public interface EditeurProvider {
    Editeur save(Editeur editeur);
    Optional<Editeur> findById(Long id);
}

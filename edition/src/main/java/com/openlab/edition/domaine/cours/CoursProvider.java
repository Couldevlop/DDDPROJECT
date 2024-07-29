package com.openlab.edition.domaine.cours;

import com.openlab.edition.domaine.cours.model.Cours;
import com.openlab.edition.domaine.editeur.model.Editeur;

import java.util.Optional;

public interface CoursProvider {
    Cours save(Cours cours);
    Optional<Cours> findById(long id);
}

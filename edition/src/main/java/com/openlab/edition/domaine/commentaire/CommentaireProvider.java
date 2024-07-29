package com.openlab.edition.domaine.commentaire;

import com.openlab.edition.domaine.commentaire.model.Commentaire;

import java.util.Optional;

public interface CommentaireProvider {
    Commentaire save(Commentaire commentaire);
    Optional<Commentaire> findById(Long id);
}

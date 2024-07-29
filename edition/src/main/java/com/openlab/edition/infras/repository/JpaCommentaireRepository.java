package com.openlab.edition.infras.repository;

import com.openlab.edition.domaine.commentaire.model.Commentaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommentaireRepository extends JpaRepository<Commentaire, Long> {
}

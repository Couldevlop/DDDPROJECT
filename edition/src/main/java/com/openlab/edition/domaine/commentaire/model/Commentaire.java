package com.openlab.edition.domaine.commentaire.model;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Commentaire {

    private Long id;
    private String texte;

    private Long auteurId;

    private Long contenuId;
    private LocalDateTime dateCreation;



    public Commentaire register(CommentaireProvider commentaireProvider){
        return commentaireProvider.save(this);
    }

    public static Optional<Commentaire> findBy(CommentaireProvider commentaireProvider, Long id){
        return commentaireProvider.findById(id);
    }
}

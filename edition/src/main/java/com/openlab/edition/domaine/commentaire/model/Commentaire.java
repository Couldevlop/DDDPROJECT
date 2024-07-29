package com.openlab.edition.domaine.commentaire.model;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Commentaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texte;
    @ManyToOne
    private Auteur auteur;
    @ManyToOne
    private Contenu contenu;



    public Commentaire register(CommentaireProvider commentaireProvider){
        return commentaireProvider.save(this);
    }

    public static Optional<Commentaire> findBy(CommentaireProvider commentaireProvider, Long id){
        return commentaireProvider.findById(id);
    }
}

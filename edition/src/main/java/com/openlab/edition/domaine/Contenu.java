package com.openlab.edition.domaine;

import com.openlab.edition.domaine.article.Status;
import com.openlab.edition.domaine.auteur.model.Auteur;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Contenu {
    private Long id;
    private String title;
    private Status status;
    private String content;
    private String domaine;
    private int nbrVues;
    @ManyToOne
    private Auteur auteur;



    public Contenu register(ContenuProvider contenuProvider){
        return contenuProvider.save(this);
    }

    public static Optional<Contenu> findById(ContenuProvider contenuProvider, Long id){
        return contenuProvider.findById(id);
    }


    public void commenter(CommentaireProvider commentaireProvider, Commentaire commentaire){
        commentaire.setContenu(this);
        commentaireProvider.register(commentaire);
    }
}

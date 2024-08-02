package com.openlab.edition.infras.entities;

import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.article.Status;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import jakarta.persistence.*;
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
@Table(name = "contenu")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class ContenuEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Status status;
    private String content;
    private String domaine;
    private int nbrVues;
    @ManyToOne
    private AuteurEntity auteurId;




}

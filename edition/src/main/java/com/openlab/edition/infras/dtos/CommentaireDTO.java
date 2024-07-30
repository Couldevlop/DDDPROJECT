package com.openlab.edition.infras.dtos;

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
public class CommentaireDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texte;
    @ManyToOne
    private Auteur auteur;
    @ManyToOne
    private Contenu contenu;



}

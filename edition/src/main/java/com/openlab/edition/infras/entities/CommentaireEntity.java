package com.openlab.edition.infras.entities;

import com.openlab.edition.domaine.Contenu;
import com.openlab.edition.domaine.auteur.model.Auteur;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CommentaireEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String texte;
    @ManyToOne
    private Auteur auteur;
    @ManyToOne
    private Contenu contenu;

}

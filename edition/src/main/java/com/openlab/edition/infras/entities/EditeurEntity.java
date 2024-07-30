package com.openlab.edition.infras.entities;

import com.openlab.edition.domaine.ContenuProvider;
import com.openlab.edition.domaine.article.Status;
import com.openlab.edition.domaine.commentaire.CommentaireProvider;
import com.openlab.edition.domaine.commentaire.model.Commentaire;
import com.openlab.edition.domaine.editeur.EditeurProvider;
import com.openlab.edition.infras.config.EmailService;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class EditeurEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String name;
    //private List<Skills> skills;




}
